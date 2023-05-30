package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReviewsCreateDto {
    private String username;
    private String reviews;
    private LocalDate date;
    @Min(value = 0, message = "Рейтинг не может быть меньше 0!")
    @Max(value = 5, message = "Рейтинг не может быть больше 5!")
    private Integer rating;
}
