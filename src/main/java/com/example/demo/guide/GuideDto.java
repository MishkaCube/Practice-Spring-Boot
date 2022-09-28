package com.example.demo.guide;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
//определяем ДТО
public class GuideDto {
    private Long id;
    private String name;
    private String second_name;
}

