package com.example.demo.mapper;

import com.example.demo.entity.Person;
import com.example.demo.person.PersonDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonDto personToPersonDto(Person entity);
    Person personDtoToPerson(PersonDto dto);

}
