package com.example.demo.controllers;

import com.example.demo.dto.ExcursionCreateDto;
import com.example.demo.dto.ExcursionDto;
import com.example.demo.service.ExcursionService;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

/**
 * REST экскурсий
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("api/excursion")
@CrossOrigin(origins = "http://localhost:3000")
public class ExcursionController {

    private final ExcursionService service;

    @GetMapping
    public List<ExcursionDto> getExcursion() {
        return service.getExcursion();
    }

    @GetMapping(
            value = "/{excursionId}",
            produces = {"application/json"}
    )
    public ResponseEntity<ExcursionDto> getExcursions(
            @Parameter(description = "Идентификатор экскурсии", required = true)
            @PositiveOrZero @PathVariable("excursionId") Long excursionId) {
        return ResponseEntity.ok(service.getExcursionById(excursionId));
    }

    @GetMapping(
            value = "/getByCity/{city}",
            produces = {"application/json"}
    )
    public List<ExcursionDto> getExcByCity(
            @Parameter(description = "Название города", required = true)
            @PositiveOrZero @PathVariable("city") String city) {
        return service.getExcByCity(city);
    }

    @DeleteMapping(value = "/{excursionId}")
    public ResponseEntity<Void> deleteExcursion(
            @Parameter(description = "Идентификатор экскурсии", required = true)
            @PositiveOrZero @PathVariable("excursionId") Long excursionId) {
        service.deleteExcursion(excursionId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/create")
    public ResponseEntity<ExcursionDto> createNew(@Parameter(description = "Запрос на создание экскурсии")
                                                            @Valid @RequestBody ExcursionCreateDto request) {
        return new ResponseEntity<>(service.createExcursion(request), HttpStatus.CREATED);
    }
}
