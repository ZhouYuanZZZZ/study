package com.zy.study;

import org.junit.Test;

import java.lang.annotation.Annotation;

public class Test1 {

    @Test
    public void test0() throws ClassNotFoundException {
        Class<?> clazz = Class.forName("com.zy.study.Test0");
        Annotation[] annotations = clazz.getAnnotations();
        for(Annotation a:annotations){
            System.out.println(a);
        }
    }
}
