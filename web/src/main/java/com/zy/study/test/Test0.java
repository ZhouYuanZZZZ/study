package com.zy.study.test;

import com.zy.study.entity.City;
import com.zy.study.utils.GsonUtil;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;

public class Test0 {

    @Test
    public void test0(){
        String hashAlgorithmName = "MD5";
        Object credentials = "081115";
        Object salt = "zy";
        int hashIterations = 1024;

        Object result = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
        System.out.println(result);
    }

    @Test
    public void test1(){
        City city = new City();
        city.setName("xxx");

        String s = GsonUtil.toGeneralJsonString(city);
        System.out.println(s);
    }
}
