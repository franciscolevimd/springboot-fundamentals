package com.fundamentosplatzi.springboot.fundamentos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private LocalDate birthDate;
}
