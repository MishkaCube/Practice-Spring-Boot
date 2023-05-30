package com.example.demo.dto;

import lombok.*;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//определяем ДТО
public class ExcursionDto {
    private Long id;
    private String name;
    private String description;
    private Integer price;
    private String image_url;
    private LocalDate date;
    private String duration;
    private String city;
}
