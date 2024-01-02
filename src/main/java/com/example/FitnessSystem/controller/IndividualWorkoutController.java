package com.example.FitnessSystem.controller;


import com.example.FitnessSystem.conversions.IndividualWorkoutConversion;
import com.example.FitnessSystem.dtos.IndividualWorkoutDto;
import com.example.FitnessSystem.model.IndividualWorkout;
import com.example.FitnessSystem.model.IndividualWorkoutId;
import com.example.FitnessSystem.service.IndividualWorkoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/private/api/individual-workouts")
@RequiredArgsConstructor
public class IndividualWorkoutController {

    private static IndividualWorkoutService individualWorkoutService;

    @GetMapping
    public ResponseEntity<List<IndividualWorkoutDto>> getAllIndividualWorkout(){
        List<IndividualWorkout> individualWorkouts = individualWorkoutService.getAllIndividualWorkouts();
        return new ResponseEntity<>(individualWorkouts.stream().map(IndividualWorkoutConversion::entityToDto).toList(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<IndividualWorkoutDto> createIndividualWorkout(@RequestBody IndividualWorkoutDto individualWorkoutDto){
        return new ResponseEntity<>(IndividualWorkoutConversion.entityToDto(individualWorkoutService
                .createIndividualWorkout(IndividualWorkoutConversion.dtoToEntity(individualWorkoutDto))), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteIndividualWorkout(@PathVariable("id") IndividualWorkoutId individualWorkoutId){
        individualWorkoutService.deleteIndividualWorkoutById(individualWorkoutId);
    }

}
