package com.qwe.asd.service;
import org.springframework.stereotype.Repository;

@Repository("studentDAO")
public class IDaoImpl  implements IDao {

    @Override
    public void show() {
        // TODO Auto-generated method stub
        System.out.println("hello,world!");
    }
}
