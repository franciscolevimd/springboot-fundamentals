package com.fundamentosplatzi.springboot.fundamentos.bean;

import org.springframework.beans.factory.annotation.Autowired;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency {
    @Autowired
    MyOperation myOperation;

    @Override
    public void printWithDependency() {
        int number = 15;
        myOperation.add(number);
        System.out.println(myOperation.add(number));
        System.out.println("Hello from a bean implementation.");
    }
}
