package com.example.demo.controllers;

import com.example.demo.entity.Person;
import com.example.demo.person.PersonDto;
import com.example.demo.service.PersonService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@Getter
@Setter
public class TestController {

    private final PersonService service;

    @GetMapping(value = "/person")
    public List<PersonDto> getPersons() {
        return service.getPersons();
    }


}
