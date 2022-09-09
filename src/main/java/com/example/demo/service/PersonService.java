package com.example.demo.service;

import com.example.demo.mapper.PersonMapper;
import com.example.demo.person.PersonDto;
import com.example.demo.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final PersonRepository repository;
    private final PersonMapper mapper;

    public List<PersonDto> getPersons() {
        return repository.findAll()
                            .stream()
                .map(mapper::personToPersonDto).collect(Collectors.toList());
    }

    public PersonService(PersonRepository repository, PersonMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
}
