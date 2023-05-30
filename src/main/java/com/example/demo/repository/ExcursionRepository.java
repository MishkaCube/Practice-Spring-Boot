package com.example.demo.repository;

import com.example.demo.entity.Excursion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExcursionRepository extends JpaRepository<Excursion, Long> {
    Optional<Excursion> findByCity(String city);
}

