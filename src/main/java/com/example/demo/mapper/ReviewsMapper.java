package com.example.demo.mapper;

import com.example.demo.dto.ReviewsCreateDto;
import com.example.demo.dto.ReviewsDto;
import com.example.demo.entity.Reviews;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReviewsMapper {
    ReviewsDto reviewsToReviewsDto(Reviews entity);

    Reviews toReviews(ReviewsCreateDto dto);
}
