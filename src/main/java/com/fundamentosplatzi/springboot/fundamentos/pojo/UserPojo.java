package com.fundamentosplatzi.springboot.fundamentos.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Data
@AllArgsConstructor
@ConstructorBinding
@ConfigurationProperties(prefix = "user")
public class UserPojo {
    private String email;
    private String password;
    private int age;
}
