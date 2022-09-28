package com.example.demo.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
//создание таблицы
public class Guide {
    @Id
    private Long id;
    private String name;
    private String second_name;
}
