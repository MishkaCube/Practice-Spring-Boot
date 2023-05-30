package com.example.demo.controllers;

import com.example.demo.dto.ExcursionCreateDto;
import com.example.demo.dto.ExcursionDto;
import com.example.demo.dto.ReviewsCreateDto;
import com.example.demo.dto.ReviewsDto;
import com.example.demo.service.ExcursionService;
import com.example.demo.service.ReviewsService;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@RestController
@RequestMapping("/reviews")
@AllArgsConstructor
@Getter
@Setter
@CrossOrigin(origins = "http://localhost:3000")
public class ReviewsController {
    private final ReviewsService service;

    @GetMapping
    public List<ReviewsDto> getReviews() {
        return service.getReviews();
    }

    @GetMapping(
            value = "/{reviewsId}",
            produces = {"application/json"}
    )
    public ResponseEntity<ReviewsDto> getReviews(
            @Parameter(description = "Идентификатор отзыва", required = true)
            @PositiveOrZero @PathVariable("reviewsId") Long reviewsId) {
        return ResponseEntity.ok(service.getReviewsById(reviewsId));
    }

    @DeleteMapping(value = "/{reviewsId}")
    public ResponseEntity<Void> deleteReviews(
            @Parameter(description = "Идентификатор отзыва", required = true)
            @PositiveOrZero @PathVariable("reviewsId") Long reviewsId) {
        service.deleteReviews(reviewsId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/create")
    public ResponseEntity<ReviewsDto> createNew(@Parameter(description = "Запрос на создание отзыва")
                                                  @Valid @RequestBody ReviewsCreateDto request) {
        return new ResponseEntity<>(service.createReviews(request), HttpStatus.CREATED);
    }
}
