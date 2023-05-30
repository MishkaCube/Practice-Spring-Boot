package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class ReviewsDto {
    private Long id;
    private String username;
    private String reviews;
    private LocalDate date;
    private Integer rating;
}
