package com.example.demo.service;

import com.example.demo.entity.Excursion;
import com.example.demo.entity.Guide;
import com.example.demo.dto.GuideCreateDto;
import com.example.demo.dto.GuideDto;
import com.example.demo.mapper.GuideMapper;
import com.example.demo.repository.ExcursionRepository;
import com.example.demo.repository.GuideRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class GuideService {

    private final GuideRepository repositoryGuide;
    private final GuideMapper mapperGuide;
    private final ExcursionRepository excursionRepository;

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

    @Transactional
    public GuideDto createGuide(GuideCreateDto request) {
        log.info("Создание гида");
        Guide guide = mapperGuide.guideCreateDtoToGuide(request);
        log.info(guide.toString());
        repositoryGuide.save(guide);
        return mapperGuide.guideToGuideDto(guide);
    }

    @Transactional
    public void setGuideForExc(Long guideId, Long excId) {
        Guide guide = repositoryGuide.findById(guideId).orElseThrow(() -> new EntityNotFoundException("Entity not Found!"));
        Excursion excursion = excursionRepository.findById(excId).orElseThrow(() -> new EntityNotFoundException("Entity not Found!"));
        excursion.setGuide(guide);
        excursionRepository.save(excursion);
    }
}
