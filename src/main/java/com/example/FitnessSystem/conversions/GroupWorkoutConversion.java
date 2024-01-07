package com.example.FitnessSystem.conversions;


import com.example.FitnessSystem.dtos.GroupWorkoutDto;
import com.example.FitnessSystem.model.FitnessUser;
import com.example.FitnessSystem.model.GroupWorkout;
import lombok.experimental.UtilityClass;

import java.util.stream.Collectors;

@UtilityClass
public class GroupWorkoutConversion {

    public static GroupWorkoutDto entityToDto(GroupWorkout groupWorkout){
        return new GroupWorkoutDto(groupWorkout.getGroupWorkoutId().getDate(),
                groupWorkout.getGroupWorkoutId().getCoach().getEmail(),
                groupWorkout.getName(),
                groupWorkout.getHallNumber(),
                groupWorkout.getDescription(),
                groupWorkout.getUsers().stream().map(FitnessUser::getEmail).collect(Collectors.toList()));
    }
}
