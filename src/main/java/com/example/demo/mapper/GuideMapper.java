package com.example.demo.mapper;

import com.example.demo.dto.GuideCreateDto;
import com.example.demo.dto.GuideDto;
import com.example.demo.entity.Guide;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface GuideMapper {
    GuideDto guideToGuideDto(Guide entity);
    Guide guideDtoToGuide(GuideCreateDto dto);
}
