package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


//определяем ДТО
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
