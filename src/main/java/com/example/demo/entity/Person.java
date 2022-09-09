package com.example.demo.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Person {

    @Id
    private Long id;
    private String name;
    private String second_name;
    private LocalDate date;

}
