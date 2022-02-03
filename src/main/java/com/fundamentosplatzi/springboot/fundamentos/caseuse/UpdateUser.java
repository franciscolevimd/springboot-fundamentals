package com.fundamentosplatzi.springboot.fundamentos.caseuse;

import com.fundamentosplatzi.springboot.fundamentos.entity.User;
import com.fundamentosplatzi.springboot.fundamentos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateUser {
    @Autowired
    private UserService userService;

    public User update(User newUser, Long id) {
        return userService.update(newUser, id);
    }
}
