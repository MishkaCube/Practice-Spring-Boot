package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "excrusions")
//создание таблицы
public class Guide {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String second_name;
    @OneToMany(mappedBy = "guide")
    private Set<Excursion> excursions;

}
