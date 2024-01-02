package com.example.FitnessSystem.controller;

import com.example.FitnessSystem.conversions.CoachConversion;
import com.example.FitnessSystem.dtos.CoachDto;
import com.example.FitnessSystem.model.Coach;
import com.example.FitnessSystem.service.CoachService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/private/api/coaches")
@RequiredArgsConstructor
public class CoachController {

    private final CoachService coachService;

    @GetMapping()
    public ResponseEntity<List<CoachDto>> getCoaches(){
        List<Coach> coaches = coachService.getAllCoaches();
        return new ResponseEntity<>(coaches.stream().map(CoachConversion::entityToDto).toList(), HttpStatus.OK);
    }

}
