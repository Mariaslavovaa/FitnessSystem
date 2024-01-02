package com.example.FitnessSystem.controller;


import com.example.FitnessSystem.conversions.GroupWorkoutConversion;
import com.example.FitnessSystem.dtos.GroupWorkoutDto;
import com.example.FitnessSystem.model.GroupWorkout;
import com.example.FitnessSystem.model.GroupWorkoutId;
import com.example.FitnessSystem.service.GroupWorkoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/private/api/group-workouts")
@RequiredArgsConstructor
public class GroupWorkoutController {

    private static GroupWorkoutService groupWorkoutService;

    @GetMapping
    public ResponseEntity<List<GroupWorkoutDto>> getAllGroupWorkout(){
        List<GroupWorkout> groupWorkouts = groupWorkoutService.getAllGroupWorkouts();
        return new ResponseEntity<>(groupWorkouts.stream().map(GroupWorkoutConversion::entityToDto).toList(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<GroupWorkoutDto> createGroupWorkout(@RequestBody GroupWorkoutDto groupWorkoutDto){
        return new ResponseEntity<>(GroupWorkoutConversion.entityToDto(groupWorkoutService
                .createGroupWorkout(GroupWorkoutConversion.dtoToEntity(groupWorkoutDto))), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteGroupWorkout(@PathVariable("id") GroupWorkoutId groupWorkoutId){
        groupWorkoutService.deleteGroupWorkoutById(groupWorkoutId);
    }
}
