package com.example.FitnessSystem.service;


import com.example.FitnessSystem.dtos.FitnessUserDto;
import com.example.FitnessSystem.dtos.GroupWorkoutDto;
import com.example.FitnessSystem.dtos.IndividualWorkoutDto;
import com.example.FitnessSystem.model.*;
import com.example.FitnessSystem.repository.CoachRepository;
import com.example.FitnessSystem.repository.FitnessUserRepository;
import com.example.FitnessSystem.repository.GroupWorkoutRepository;
import com.example.FitnessSystem.repository.IndividualWorkoutRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FitnessUserServiceImpl implements FitnessUserService{

    private final FitnessUserRepository fitnessUserRepo;
    private final IndividualWorkoutRepository individualWorkoutRepository;
    private final GroupWorkoutRepository groupWorkoutRepository;
    private final CoachRepository coachRepository;



    @Override
    public FitnessUserDto createUser(FitnessUserDto fitnessUser) {
        FitnessUser toSave = new FitnessUser();
        toSave.setUsername(fitnessUser.getUsername());
        toSave.setEmail(fitnessUser.getEmail());
        toSave.setPassword(fitnessUser.getPassword());

        List<IndividualWorkout> individualWorkouts = new ArrayList<>();
        fitnessUser.getIndividualWorkouts().forEach(individualWorkoutDto -> {
            Coach found = coachRepository.findByEmail(individualWorkoutDto.getCoach()).orElseThrow();
            IndividualWorkout foundWorkout = individualWorkoutRepository.findById(
                    new IndividualWorkoutId(individualWorkoutDto.getLocalDateTime(), found)).orElseThrow();
            individualWorkouts.add(foundWorkout);
        });

        List<GroupWorkout> groupWorkouts = new ArrayList<>();
        fitnessUser.getGroupWorkouts().forEach(groupWorkoutDto -> {
            Coach found = coachRepository.findByEmail(groupWorkoutDto.getCoach()).orElseThrow();
            GroupWorkout foundGroupWorkout = groupWorkoutRepository.findById(
                    new GroupWorkoutId(groupWorkoutDto.getDate(), found)).orElseThrow();
            groupWorkouts.add(foundGroupWorkout);
        });

        toSave.setGroupWorkouts(groupWorkouts);
        toSave.setIndividualWorkouts(individualWorkouts);
        fitnessUserRepo.save(toSave);
        return fitnessUser;
    }

    @Override
    public FitnessUserDto login(String username, String password) {
        FitnessUser found = fitnessUserRepo.findByUsernameAndPassword(username.trim(), password.trim())
                .orElseThrow(EntityNotFoundException::new);

        FitnessUserDto result = new FitnessUserDto();
        result.setEmail(found.getEmail());
        result.setUsername(found.getUsername());
        result.setPassword(found.getPassword());

        result.setGroupWorkouts(found.getGroupWorkouts().stream().map(groupWorkout -> new GroupWorkoutDto(
                groupWorkout.getGroupWorkoutId().getDate(), groupWorkout.getGroupWorkoutId().getCoach().getEmail(),
                groupWorkout.getName(), groupWorkout.getHallNumber(), groupWorkout.getDescription(),
                groupWorkout.getUsers().stream().map(FitnessUser::getEmail).toList())).toList());

        result.setIndividualWorkouts(found.getIndividualWorkouts().stream().map(individualWorkout -> new IndividualWorkoutDto(
                individualWorkout.getIndividualWorkoutId().getLocalDateTime(),
                individualWorkout.getIndividualWorkoutId().getCoach().getEmail(),
                individualWorkout.getFitnessUser().getEmail())).toList());

        return result;
    }

    @Override
    public FitnessUser findByUsername(String username) {
        return fitnessUserRepo.findByUsername(username).orElseThrow(EntityNotFoundException::new);
    }
}
