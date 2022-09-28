package com.example.demo.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
//создание таблицы
public class Excursion {

    @Id
    private Long id;
    private String name;
    private String description;
    private Integer price;

}
