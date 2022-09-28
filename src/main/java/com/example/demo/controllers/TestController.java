package com.example.demo.controllers;

import com.example.demo.excursion.ExcursionCreateDto;
import com.example.demo.excursion.ExcursionDto;
import com.example.demo.service.ExcursionService;
import com.example.demo.service.GuideService;
import com.example.demo.guide.GuideCreateDto;
import com.example.demo.guide.GuideDto;
import com.example.demo.service.GuideService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@RestController
@AllArgsConstructor
@Getter
@Setter
public class TestController {

    private final ExcursionService ExcurService;

    @GetMapping(value = "/excursion")
    public List<ExcursionDto> getExcursion() {
        return ExcurService.getExcursion();
    }

    @GetMapping(
            value = "/excursion/excursionID",
            produces = {"application/json"}
    )
    public ResponseEntity<ExcursionDto> getExcursions(
            @Parameter(description = "Идентификатор экскурсии", required = true)
            @PositiveOrZero @PathVariable("excursionID") Long excursionID) {
        return ResponseEntity.ok(ExcurService.getExcursionByID(excursionID));
    }

    @DeleteMapping(value = "/excursion/{excursionID}")
    public ResponseEntity<Void> deleteExcursion(
            @Parameter(description = "Идентификатор экскурсии", required = true)
            @PositiveOrZero @PathVariable("excursionID") Long excursionID) {
        ExcurService.deleteExcursion(excursionID);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "excursion/createExcursion")
    public ResponseEntity<ExcursionDto> createExcursion(
            @Parameter(description = "Запрос на создание экскурсии")
            @Valid @RequestBody ExcursionCreateDto request) {
        return new ResponseEntity<>(ExcurService.createExcursion(request), HttpStatus.CREATED);
    }



/*-------------------------------------------------------------------------------------------------------------------------------------------*/


    private final GuideService GuiService;

    @GetMapping(value = "/Guide")
    public List<GuideDto> getGuide() {
        return GuiService.getGuide();
    }

    @GetMapping(
            value = "/Guide/GuideID",
            produces = {"application/json"}
    )
    public ResponseEntity<GuideDto> getGuide(
            @Parameter(description = "Идентификатор гида", required = true)
            @PositiveOrZero @PathVariable("GuideID") Long GuideID) {
        return ResponseEntity.ok(GuiService.getGuideByID(GuideID));
    }

    @DeleteMapping(value = "/Guide/{GuideID}")
    public ResponseEntity<Void> deleteGuide(
            @Parameter(description = "Идентификатор гида", required = true)
            @PositiveOrZero @PathVariable("GuideID") Long GuideID) {
        GuiService.deleteGuide(GuideID);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "guide/createGuide")
    public ResponseEntity<GuideDto> createGuide(
            @Parameter(description = "Запрос на создание гида")
            @Valid @RequestBody GuideCreateDto request) {
        return new ResponseEntity<>(GuiService.createGuide(request), HttpStatus.CREATED);
    }
}
