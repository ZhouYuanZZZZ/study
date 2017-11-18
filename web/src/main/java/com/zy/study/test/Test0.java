package com.zy.study.test;

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
}
