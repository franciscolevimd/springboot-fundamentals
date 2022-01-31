package com.fundamentosplatzi.springboot.fundamentos.component;

import org.springframework.stereotype.Component;

@Component
public class ComponenteTwoImplement implements ComponentDependency {
    @Override
    public void greet() {
        System.out.println("Hol de nuevo garrpán.");
    }
}
