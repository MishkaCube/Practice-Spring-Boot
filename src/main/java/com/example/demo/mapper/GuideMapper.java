package com.example.demo.mapper;

import com.example.demo.entity.Guide;
import com.example.demo.dto.GuideCreateDto;
import com.example.demo.dto.GuideDto;
import org.mapstruct.Mapper;
//чтобы маппер тоже был spring Bean, те маппер тоже участвует в приложении
@Mapper(componentModel = "spring")
//методы для превращения сущности в ДТО и обратно
public interface GuideMapper {
    GuideDto guideToGuideDto(Guide entity);
    Guide guideDtoToGuide(GuideCreateDto dto);
}
