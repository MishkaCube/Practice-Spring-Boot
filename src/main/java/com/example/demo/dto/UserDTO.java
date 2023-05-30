package com.example.demo.dto;

import com.example.demo.entity.UserRole;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDTO {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private Integer age;
    private Boolean isActive;
    private UserRole role;
    private LocalDateTime timestamp;
}
