package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; private String username;
    private String reviews;
    private LocalDate date;
    @Min(value = 0, message = "Рейтинг не может быть меньше 0!")
    @Max(value = 5, message = "Рейтинг не может быть больше 5!")
    private Integer rating;

}
