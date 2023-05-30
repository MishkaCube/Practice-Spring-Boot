package com.example.demo.controllers;

import com.example.demo.dto.GuideCreateDto;
import com.example.demo.dto.GuideDto;
import com.example.demo.service.GuideService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@RestController
@AllArgsConstructor
public class GuideController {

    private final GuideService service;

    @GetMapping(value = "/Guide")
    public List<GuideDto> getGuide() {
        return service.getGuide();
    }

    @GetMapping(
            value = "/Guide/{GuideID}",
            produces = {"application/json"}
    )
    public ResponseEntity<GuideDto> getGuide(
            @Parameter(description = "Идентификатор гида", required = true)
            @PositiveOrZero @PathVariable("GuideID") Long GuideID) {
        return ResponseEntity.ok(service.getGuideByID(GuideID));
    }

    @DeleteMapping(value = "/Guide/{GuideID}")
    public ResponseEntity<Void> deleteGuide(
            @Parameter(description = "Идентификатор гида", required = true)
            @PositiveOrZero @PathVariable("GuideID") Long GuideID) {
        service.deleteGuide(GuideID);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/Guide/createGuide")
    public ResponseEntity<GuideDto> createGuide(
            @Parameter(description = "Запрос на создание гида")
            @Valid @RequestBody GuideCreateDto request) {
        return new ResponseEntity<>(service.createGuide(request), HttpStatus.CREATED);
    }

    @PutMapping(value = "/guide/setGuide")
    public ResponseEntity<Void> setGuideForExc(
            @PositiveOrZero @RequestParam("guideId") Long guideId,
            @PositiveOrZero @RequestParam("excId") Long excId
    ) {
        service.setGuideForExc(guideId, excId);
        return ResponseEntity.noContent().build();
    }

}
