package com.example.demo.mapper;

import com.example.demo.entity.Excursion;
import com.example.demo.dto.ExcursionCreateDto;
import com.example.demo.dto.ExcursionDto;
import org.mapstruct.Mapper;


/**
 * Маппер
 * Преобразует объект одного типа в объект другого типа
 * Параметр componentModel выбирает scope работы бина
 * В представленном случае указывается "spring" (строковое представление application context),
 * проще говоря мы заносим его в Application context чтобы потом юзать в других компонентах (делать DI)
 * Уж что такое DI в спринге сама погуглишь я нахуй не википедия
 */
@Mapper(componentModel = "spring")
public interface ExcursionMapper {

    /**
     * @param entity принимает объект который нужно преобразовать
     * @return ExcursionDto, то есть объект который должен получится из класса Excursion
     */
    ExcursionDto excursionToExcursionDto(Excursion entity);

    Excursion toExcursion(ExcursionCreateDto dto);

}
