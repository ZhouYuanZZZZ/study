package com.zy.study;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value = RetentionPolicy.RUNTIME)
public @interface zy {

    String name() default "zy";
    int age() default 23;
}
