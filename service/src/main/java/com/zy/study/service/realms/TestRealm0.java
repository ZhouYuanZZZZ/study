package com.zy.study.service.realms;

import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class TestRealm0 extends AuthenticatingRealm {

    public TestRealm0() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("MD5");
        //加密的次数
        hashedCredentialsMatcher.setHashIterations(1024);

        this.setCredentialsMatcher(hashedCredentialsMatcher);
    }

   private static final Logger logger = LoggerFactory.getLogger(TestRealm0.class);
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.info("exe doGetAuthenticationInfo: {}",authenticationToken.toString());
        //1. 把 AuthenticationToken 转换为 UsernamePasswordToken
        UsernamePasswordToken upToken = (UsernamePasswordToken) authenticationToken;

        //2. 从 UsernamePasswordToken 中来获取 username
        String username = upToken.getUsername();

        //3. 调用数据库的方法, 从数据库中查询 username 对应的用户记录
        logger.info("从数据库中获取 username: " + username + " 所对应的用户信息.");

        //4. 若用户不存在, 则可以抛出 UnknownAccountException 异常
        if("unknown".equals(username)){
            throw new UnknownAccountException("用户不存在!");
        }

        //5. 根据用户信息的情况, 决定是否需要抛出其他的 AuthenticationException 异常.
        if("monster".equals(username)){
            throw new LockedAccountException("用户被锁定");
        }

        //6. 根据用户的情况, 来构建 AuthenticationInfo 对象并返回. 通常使用的实现类为: SimpleAuthenticationInfo
        //以下信息是从数据库中获取的.从数据库取出的密码只起对比的作用
        //1). principal: 认证的实体信息. 可以是 username, 也可以是数据表对应的用户的实体类对象.
        Object principal = username;
        //2). credentials: 密码.
        Object credentials = "2fc3a15fae22803597790c223f137599";
        //3.realm Name
        String realmName = super.getName();
        //加盐,给用户的输入的token中的密码进行加盐加密操作
        ByteSource credentialsSalt = ByteSource.Util.bytes(username);
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal,credentials,credentialsSalt,realmName);

        return info;
    }
}
