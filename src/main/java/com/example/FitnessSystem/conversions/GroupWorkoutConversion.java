package com.example.FitnessSystem.conversions;


import com.example.FitnessSystem.dtos.GroupWorkoutDto;
import com.example.FitnessSystem.model.GroupWorkout;
import com.example.FitnessSystem.model.GroupWorkoutId;
import lombok.experimental.UtilityClass;

import java.util.stream.Collectors;

@UtilityClass
public class GroupWorkoutConversion {

    public static GroupWorkoutDto entityToDto(GroupWorkout groupWorkout){
        return new GroupWorkoutDto(groupWorkout.getGroupWorkoutId().getDate(),
                CoachConversion.entityToDto(groupWorkout.getGroupWorkoutId().getCoach()),
                groupWorkout.getName(),
                groupWorkout.getHallNumber(),
                groupWorkout.getDescription(),
                groupWorkout.getUsers().stream().map(FitnessUserConversion::entityToDto).collect(Collectors.toList()));
    }

    public static GroupWorkout dtoToEntity(GroupWorkoutDto groupWorkoutDto){
        return new GroupWorkout(new GroupWorkoutId(groupWorkoutDto.getDate(),
                CoachConversion.dtoToEntity(groupWorkoutDto.getCoach())),
                groupWorkoutDto.getName(),
                groupWorkoutDto.getHallNumber(),
                groupWorkoutDto.getDescription(),
                groupWorkoutDto.getUsers().stream().map(FitnessUserConversion::dtoToEntity).collect(Collectors.toList()));
    }
}
