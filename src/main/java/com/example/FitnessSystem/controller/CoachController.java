package com.example.FitnessSystem.controller;

import com.example.FitnessSystem.dtos.CoachDto;
import com.example.FitnessSystem.dtos.GroupWorkoutDto;
import com.example.FitnessSystem.dtos.IndividualWorkoutDto;
import com.example.FitnessSystem.model.Coach;
import com.example.FitnessSystem.model.FitnessUser;
import com.example.FitnessSystem.service.CoachService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/private/api/coaches")
@RequiredArgsConstructor
@CrossOrigin
public class CoachController {

    private final CoachService coachService;

    @GetMapping()
    public ResponseEntity<List<CoachDto>> getCoaches(){
        List<Coach> coaches = coachService.getAllCoaches();
        List<CoachDto> dtos = new ArrayList<>();
        for (Coach c : coaches){
            CoachDto temp = new CoachDto();
            temp.setEducation(c.getEducation());
            temp.setEmail(c.getEmail());
            temp.setUsername(c.getUsername());
            temp.setPhoneNumber(c.getPhoneNumber());
            temp.setGroupWorkouts(c.getGroupWorkouts().stream().map(groupWorkout -> new GroupWorkoutDto(groupWorkout.getGroupWorkoutId().getDate(),
                    temp.getEmail(),
                    groupWorkout.getName(),
                    groupWorkout.getHallNumber(),
                    groupWorkout.getDescription(),
                    groupWorkout.getUsers().stream().map(FitnessUser::getEmail).collect(Collectors.toList()))).collect(Collectors.toList()));
            temp.setIndividualWorkouts(c.getIndividualWorkouts().stream().map(
                    individualWorkout ->  new IndividualWorkoutDto(individualWorkout.getIndividualWorkoutId().getLocalDateTime(),
                            temp.getEmail(),
                            individualWorkout.getFitnessUser().getEmail())).collect(Collectors.toList()));

            dtos.add(temp);
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

}
