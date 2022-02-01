package com.fundamentosplatzi.springboot.fundamentos.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class MyBeanWithDependencyImplement implements MyBeanWithDependency {
    @Autowired
    MyOperation myOperation;

    @Override
    public void printWithDependency() {
        log.info("Hemos ingresado al método printWithDependency");
        int number = 15;
        log.debug("EL número enviado como parámetro a la dependencia operation es: " + number);
        myOperation.add(number);
        log.info(String.valueOf(myOperation.add(number)));
        log.info("Hello from a bean implementation.");
    }
}
