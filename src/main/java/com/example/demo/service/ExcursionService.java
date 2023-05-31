package com.example.demo.service;

import com.example.demo.entity.Excursion;
import com.example.demo.dto.ExcursionCreateDto;
import com.example.demo.mapper.ExcursionMapper;
import com.example.demo.dto.ExcursionDto;
import com.example.demo.repository.ExcursionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ExcursionService {

    private final ExcursionRepository repository;
    private final ExcursionMapper mapper;


    public List<ExcursionDto> getExcursion() {
        return repository.findAll()
                            .stream()
                .map(mapper::excursionToExcursionDto).collect(Collectors.toList());
    }

    public ExcursionDto getExcursionById(Long id)  {
        return mapper.excursionToExcursionDto((repository.findById(id).orElse(null)));
    }

    public void deleteExcursion (Long id) {
            repository.deleteById(id);
    }

    @Transactional
    public ExcursionDto createExcursion(ExcursionCreateDto request) {
        log.info("Создание экскурсии");
        Excursion excursion = mapper.toExcursion(request);
        repository.save(excursion);
        return mapper.excursionToExcursionDto(excursion);
    }

    public List<ExcursionDto> getExcByCity(String city) {
        return repository.findByCity(city).stream().map(mapper::excursionToExcursionDto).collect(Collectors.toList());
    }
}
