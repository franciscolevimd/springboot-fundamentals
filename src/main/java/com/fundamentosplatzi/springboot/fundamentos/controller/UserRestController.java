package com.fundamentosplatzi.springboot.fundamentos.controller;

import com.fundamentosplatzi.springboot.fundamentos.caseuse.GetUser;
import com.fundamentosplatzi.springboot.fundamentos.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
    @Autowired
    private GetUser getUser;

    @GetMapping("/")
    public List<User> get() {
        return getUser.getAll();
    }
}
