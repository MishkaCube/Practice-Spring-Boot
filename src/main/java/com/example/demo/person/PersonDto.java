package com.example.demo.person;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class PersonDto {
    private Long id;
    private String name;
    private String second_name;
    private LocalDate date;
}
