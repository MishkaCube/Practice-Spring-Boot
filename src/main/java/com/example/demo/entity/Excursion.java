package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Excursion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private Integer price;
    @Column(name = "image_url")
    private String image_url;
    @NotNull
    private LocalDate date;
    @NotNull
    private String duration;
    @ManyToOne
    @JoinColumn(name = "excursion_id", nullable = true)
    private Guide guide;
    @NotNull
    private String city;
}
