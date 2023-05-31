package com.example.demo.dto;

import com.example.demo.entity.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import javax.validation.constraints.Email;
import java.time.LocalDateTime;

@Data
@With
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateDTO {
    private String name;
    private String surname;
    private String email;
    private String password;
    private Integer age;
    private UserRole role;
    private Boolean isActive;
    private LocalDateTime timestamp;
}
