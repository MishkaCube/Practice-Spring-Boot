package com.example.demo.dto;

import lombok.With;

@With
public record AuthDto(String email, String password) {

}
