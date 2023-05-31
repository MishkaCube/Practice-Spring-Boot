package com.example.demo.dto;

import java.time.LocalDate;


//определяем ДТО
public record ExcursionDto(Long id, String name, String description, Integer price, String image_url, LocalDate date,
                           String duration, String city) {

}
