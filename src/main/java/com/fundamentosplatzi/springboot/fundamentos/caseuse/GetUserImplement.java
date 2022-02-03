package com.fundamentosplatzi.springboot.fundamentos.caseuse;

import com.fundamentosplatzi.springboot.fundamentos.entity.User;
import com.fundamentosplatzi.springboot.fundamentos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GetUserImplement implements GetUser {
    @Autowired
    private UserService userService;

    @Override
    public List<User> getAll() {
        return userService.getAllUsers();
    }
}
