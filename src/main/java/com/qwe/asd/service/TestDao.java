package com.qwe.asd.service;

import org.springframework.stereotype.Component;

@Component
public class TestDao {
    private String wwww;

    public void setWwww(String wwww) {
        this.wwww = wwww;
    }

    public void say(){
        System.out.println("hello dao");
        System.out.println(this.wwww);
    }
}
