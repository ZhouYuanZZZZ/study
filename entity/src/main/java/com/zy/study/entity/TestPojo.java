package com.zy.study.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class TestPojo {


    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
