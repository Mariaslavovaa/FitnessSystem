package com.example.FitnessSystem.service;

import com.example.FitnessSystem.model.GroupWorkout;
import com.example.FitnessSystem.model.GroupWorkoutId;

import java.util.List;

public interface GroupWorkoutService {

    GroupWorkout createGroupWorkout(GroupWorkout groupWorkout);
    void deleteGroupWorkoutById(GroupWorkoutId groupWorkoutId);
    List<GroupWorkout> getAllGroupWorkouts();
}
