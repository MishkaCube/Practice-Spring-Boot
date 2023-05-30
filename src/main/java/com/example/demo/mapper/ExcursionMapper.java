package com.example.demo.mapper;

import com.example.demo.entity.Excursion;
import com.example.demo.dto.ExcursionCreateDto;
import com.example.demo.dto.ExcursionDto;
import org.mapstruct.Mapper;


//чтобы маппер тоже был spring Bean, те маппер тоже участвует в приложении
@Mapper(componentModel = "spring")
//методы для превращения сущности в ДТО и обратно
public interface ExcursionMapper {

    ExcursionDto excursionToExcursionDto(Excursion entity);

    Excursion toExcursion(ExcursionCreateDto dto);

}
