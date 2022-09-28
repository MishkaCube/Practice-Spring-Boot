package com.example.demo.service;

import com.example.demo.entity.Guide;
import com.example.demo.guide.GuideCreateDto;
import com.example.demo.guide.GuideDto;
import com.example.demo.mapper.GuideMapper;
import com.example.demo.repository.GuideRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class GuideService {
    private final GuideRepository repositoryGuide;
    private final GuideMapper mapperGuide;

    public GuideService(GuideRepository repository, GuideMapper mapper) {
        this.repositoryGuide = repository;
        this.mapperGuide = mapper;
    }

    public List<GuideDto> getGuide() {
        return repositoryGuide.findAll()
                .stream()
                .map(mapperGuide::guideToGuideDto).collect(Collectors.toList());
    }

    public GuideDto getGuideByID(Long id)  {
        return mapperGuide.guideToGuideDto((repositoryGuide.findById(id).orElse(null)));
    }

    public void deleteGuide (Long id) {
        repositoryGuide.deleteById(id);
    }

    public GuideDto createGuide(GuideCreateDto request) {
        log.info("Создание гида");
        Guide Guide = mapperGuide.guideDtoToGuide(request);
        repositoryGuide.save(Guide);
        return mapperGuide.guideToGuideDto(Guide);
    }
}
