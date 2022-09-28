package com.example.demo.repository;

import com.example.demo.entity.Excursion;
import com.example.demo.entity.Guide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuideRepository  extends  JpaRepository<Guide, Long> {
}
