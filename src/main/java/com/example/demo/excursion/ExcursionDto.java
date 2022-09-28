package com.example.demo.excursion;

import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
//определяем ДТО
public class ExcursionDto {
    private Long id;
    private String name;
    private String description;
    private Integer price;
}
