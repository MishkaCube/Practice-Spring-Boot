package com.example.demo.controllers;

import com.example.demo.dto.GuideCreateDto;
import com.example.demo.dto.GuideDto;
import com.example.demo.dto.ReviewsCreateDto;
import com.example.demo.dto.ReviewsDto;
import com.example.demo.service.GuideService;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/guide")
@RequiredArgsConstructor
public class GuideController {

    private final GuideService service;

    @GetMapping
    public ResponseEntity<Object> getGuide() {
        try {
            return new ResponseEntity<>(service.getGuide(), HttpStatus.ACCEPTED);
        } catch (Exception exception) {
            return new ResponseEntity<>(exception.toString(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping(
            value = "/{guideId}",
            produces = {"application/json"}
    )
    public ResponseEntity<Object> getGuide(
            @Parameter(description = "Идентификатор гида", required = true)
            @PositiveOrZero @PathVariable("guideId") Long guideId) {
        try {
            return new ResponseEntity<>(service.getGuideByID(guideId), HttpStatus.ACCEPTED);
        } catch (Exception exception) {
            return new ResponseEntity<>(exception.toString(), HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping(value = "/{guideId}")
    public ResponseEntity<Object> deleteGuide(
            @Parameter(description = "Идентификатор гида", required = true)
            @PositiveOrZero @PathVariable("guideId") Long guideId) {
        try {
            service.deleteGuide(guideId);
            return ResponseEntity.noContent().build();
        } catch (Exception exception) {
            return ResponseEntity.internalServerError().body(exception.toString());
        }

    }

    @PostMapping(value = "/create")
    public ResponseEntity<GuideDto> createNew(@Parameter(description = "Запрос на создание гида")
                                                @Valid @RequestBody GuideCreateDto request) {
        return new ResponseEntity<>(service.createGuide(request), HttpStatus.CREATED);
    }

    @PutMapping(value = "/guide/setGuide")
    public ResponseEntity<Object> setGuideForExc(
            @PositiveOrZero @RequestParam("guideId") Long guideId,
            @PositiveOrZero @RequestParam("excId") Long excId
    ) {
        try {
            service.setGuideForExc(guideId, excId);
            return ResponseEntity.accepted().body("Successful");
        } catch (Exception exception) {
            return ResponseEntity.internalServerError().body(exception.toString());
        }
    }

}
