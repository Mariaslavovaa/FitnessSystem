package com.example.FitnessSystem.service;


import com.example.FitnessSystem.model.GroupWorkout;
import com.example.FitnessSystem.model.GroupWorkoutId;
import com.example.FitnessSystem.repository.GroupWorkoutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupWorkoutServiceImpl implements GroupWorkoutService {

    private final GroupWorkoutRepository groupWorkoutRepo;

    @Override
    public GroupWorkout createGroupWorkout(GroupWorkout groupWorkout) {
        if(groupWorkout == null){
            throw new IllegalArgumentException("Group workout cannot be null!");
        }
        return groupWorkoutRepo.save(groupWorkout);
    }

    @Override
    public void deleteGroupWorkoutById(GroupWorkoutId groupWorkoutId) {
        groupWorkoutRepo.deleteById(groupWorkoutId);
    }

    @Override
    public List<GroupWorkout> getAllGroupWorkouts() {
        List<GroupWorkout> groupWorkouts = new ArrayList<>();
        groupWorkoutRepo.findAll().forEach(groupWorkouts::add);
        return groupWorkouts;
    }
}
