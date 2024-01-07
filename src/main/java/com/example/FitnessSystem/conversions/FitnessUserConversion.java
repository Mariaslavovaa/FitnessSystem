package com.example.FitnessSystem.conversions;

import com.example.FitnessSystem.dtos.FitnessUserDto;
import com.example.FitnessSystem.model.FitnessUser;
import lombok.experimental.UtilityClass;

import java.util.stream.Collectors;

@UtilityClass
public class FitnessUserConversion {

//    public static FitnessUserDto entityToDto(FitnessUser fitnessUser){
//        return new FitnessUserDto(fitnessUser.getEmail(), fitnessUser.getUsername(), fitnessUser.getPassword(),
//                fitnessUser.getIndividualWorkouts().stream().map(IndividualWorkoutConversion::entityToDto).collect(Collectors.toList()),
//                fitnessUser.getGroupWorkouts().stream().map(GroupWorkoutConversion::entityToDto).collect(Collectors.toList()));
//    }
//
//    public static FitnessUser dtoToEntity(FitnessUserDto fitnessUserDto){
//        return new FitnessUser(fitnessUserDto.getEmail(), fitnessUserDto.getUsername(), fitnessUserDto.getPassword(),
//                fitnessUserDto.getIndividualWorkouts().stream().map(IndividualWorkoutConversion::dtoToEntity).collect(Collectors.toList()),
//                fitnessUserDto.getGroupWorkouts().stream().map(GroupWorkoutConversion::dtoToEntity).collect(Collectors.toList()));
//    }
}
