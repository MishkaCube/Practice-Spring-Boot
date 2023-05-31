package com.example.demo.dto;

import java.time.LocalDate;

public record ReviewsDto(Long id, String username, String reviews, LocalDate date, Integer rating) {
}
