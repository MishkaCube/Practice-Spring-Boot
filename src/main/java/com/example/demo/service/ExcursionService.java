package com.example.demo.service;

import com.example.demo.entity.Excursion;
import com.example.demo.excursion.ExcursionCreateDto;
import com.example.demo.mapper.ExcursionMapper;
import com.example.demo.excursion.ExcursionDto;
import com.example.demo.repository.ExcursionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ExcursionService {

    private final ExcursionRepository repository;
    private final ExcursionMapper mapper;

    public ExcursionService(ExcursionRepository repository, ExcursionMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<ExcursionDto> getExcursion() {
        return repository.findAll()
                            .stream()
                .map(mapper::excursionToExcursionDto).collect(Collectors.toList());
    }

    public ExcursionDto getExcursionByID(Long id)  {
        return mapper.excursionToExcursionDto((repository.findById(id).orElse(null)));
    }

    public void deleteExcursion (Long id) {
            repository.deleteById(id);
    }

    public ExcursionDto createExcursion(ExcursionCreateDto request) {
        log.info("Создание экскурсии");
        Excursion excursion = mapper.excursionDtoToExcursion(request);
        repository.save(excursion);
        return mapper.excursionToExcursionDto(excursion);
    }
}
