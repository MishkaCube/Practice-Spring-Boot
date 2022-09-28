package com.example.demo.excursion;

import lombok.Data;

@Data
public class ExcursionCreateDto {
    private String name;
    private String description;
    private Integer price;
}
