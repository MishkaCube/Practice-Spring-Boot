package com.example.demo.dto;

import com.example.demo.entity.UserRole;
import lombok.Data;

import javax.validation.constraints.Email;
import java.time.LocalDateTime;

@Data
public class UserCreateDTO {
    private String name;
    private String surname;
    @Email
    private String email;
    private String password;
    private Integer age;
    private UserRole role;
    private Boolean isActive;
    private LocalDateTime timestamp;
}
