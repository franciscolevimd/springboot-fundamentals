package com.fundamentosplatzi.springboot.fundamentos.bean;

public class MyOperationImplement implements MyOperation {
    @Override
    public int add(int number) {
        return number + 1;
    }
}
