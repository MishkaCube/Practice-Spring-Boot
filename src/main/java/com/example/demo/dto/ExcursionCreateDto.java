package com.example.demo.dto;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExcursionCreateDto {
    private String name;
    private String description;
    private Integer price;
    private String image_url;
    private LocalDate date;
    private String duration;
    private String city;
}
