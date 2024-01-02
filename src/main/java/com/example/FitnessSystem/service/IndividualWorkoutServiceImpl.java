package com.example.FitnessSystem.service;

import com.example.FitnessSystem.model.IndividualWorkout;
import com.example.FitnessSystem.model.IndividualWorkoutId;
import com.example.FitnessSystem.repository.IndividualWorkoutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IndividualWorkoutServiceImpl implements IndividualWorkoutService{

    private final IndividualWorkoutRepository individualWorkoutRepo;

    @Override
    public IndividualWorkout createIndividualWorkout(IndividualWorkout individualWorkout) {
        if(individualWorkout == null){
            throw new IllegalArgumentException("Individual workout cannot be null!");
        }
        return individualWorkoutRepo.save(individualWorkout);
    }

    @Override
    public void deleteIndividualWorkoutById(IndividualWorkoutId individualWorkoutId) {
        individualWorkoutRepo.deleteById(individualWorkoutId);
    }

    @Override
    public List<IndividualWorkout> getAllIndividualWorkouts() {
        List<IndividualWorkout> individualWorkouts = new ArrayList<>();
        individualWorkoutRepo.findAll().forEach(individualWorkouts::add);
        return individualWorkouts;
    }
}
