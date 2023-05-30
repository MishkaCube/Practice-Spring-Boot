package com.example.demo.service;

import com.example.demo.dto.ExcursionCreateDto;
import com.example.demo.dto.ExcursionDto;
import com.example.demo.dto.ReviewsCreateDto;
import com.example.demo.dto.ReviewsDto;
import com.example.demo.entity.Excursion;
import com.example.demo.entity.Reviews;
import com.example.demo.mapper.ExcursionMapper;
import com.example.demo.mapper.ReviewsMapper;
import com.example.demo.repository.ExcursionRepository;
import com.example.demo.repository.ReviewsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReviewsService {

    private final ReviewsRepository repository;
    private final ReviewsMapper mapper;

    public List<ReviewsDto> getReviews() {
        return repository.findAll()
                .stream()
                .map(mapper::reviewsToReviewsDto).collect(Collectors.toList());
    }

    public ReviewsDto getReviewsById(Long id)  {
        return mapper.reviewsToReviewsDto((repository.findById(id).orElse(null)));
    }

    public void deleteReviews (Long id) {
        repository.deleteById(id);
    }

    public ReviewsDto createReviews(ReviewsCreateDto request) {
        log.info("Создание отзыва");
        Reviews reviews = mapper.toReviews(request);
        repository.save(reviews);
        return mapper.reviewsToReviewsDto(reviews);
    }
}
