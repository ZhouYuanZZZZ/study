package com.zy.study.service.commno;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class FilterChainDefinitionMapBuilder {

    Map<String,String> buildFilterChainDefinitionMap(){

        Map<String,String> map = new HashMap<>();

        map.put("/login.jsp", "anon");
        map.put("/rest/shiro/login", "anon");
        map.put("/shiro/logout", "logout");
        map.put("/user.jsp", "authc,roles[user]");
        map.put("/admin.jsp", "authc,roles[admin]");
        map.put("/list.jsp", "authc");

        map.put("/**", "authc");

        return map;
    }
}
