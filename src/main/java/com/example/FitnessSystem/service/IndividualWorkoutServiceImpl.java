package com.example.FitnessSystem.service;

import com.example.FitnessSystem.dtos.IndividualWorkoutDto;
import com.example.FitnessSystem.model.Coach;
import com.example.FitnessSystem.model.IndividualWorkout;
import com.example.FitnessSystem.model.IndividualWorkoutId;
import com.example.FitnessSystem.repository.CoachRepository;
import com.example.FitnessSystem.repository.FitnessUserRepository;
import com.example.FitnessSystem.repository.IndividualWorkoutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IndividualWorkoutServiceImpl implements IndividualWorkoutService{

    private final IndividualWorkoutRepository individualWorkoutRepo;
    private final CoachRepository coachRepository;
    private final FitnessUserRepository fitnessUserRepository;

    @Override
    public IndividualWorkoutDto createIndividualWorkout(IndividualWorkoutDto individualWorkout) {
        Coach found = coachRepository.findByEmail(individualWorkout.getCoach().trim()).orElseThrow();
        IndividualWorkout toSave = new IndividualWorkout();
        toSave.setIndividualWorkoutId(new IndividualWorkoutId(individualWorkout.getLocalDateTime(), found));
        toSave.setFitnessUser(fitnessUserRepository.findByEmail(individualWorkout.getFitnessUser()).orElseThrow());
        individualWorkoutRepo.save(toSave);
        return individualWorkout;
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
