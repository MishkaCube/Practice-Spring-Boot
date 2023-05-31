package com.example.demo.repository;

import com.example.demo.entity.Excursion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExcursionRepository extends JpaRepository<Excursion, Long> {

    /**
     * @param city
     * @return object of Excursion entity
     * SELECT * FROM excursions WHERE city = {}
     */
    Optional<Excursion> findByCity(String city);
}

