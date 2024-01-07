package com.example.FitnessSystem.service;

import com.example.FitnessSystem.dtos.IndividualWorkoutDto;
import com.example.FitnessSystem.model.IndividualWorkout;
import com.example.FitnessSystem.model.IndividualWorkoutId;

import java.util.List;

public interface IndividualWorkoutService {
    IndividualWorkoutDto createIndividualWorkout(IndividualWorkoutDto individualWorkout);
    void deleteIndividualWorkoutById(IndividualWorkoutId individualWorkoutId);
    List<IndividualWorkout> getAllIndividualWorkouts();
}
