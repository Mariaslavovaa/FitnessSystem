package com.example.FitnessSystem.conversions;

import com.example.FitnessSystem.dtos.FitnessUserDto;
import com.example.FitnessSystem.model.FitnessUser;
import lombok.experimental.UtilityClass;

@UtilityClass
public class FitnessUserConversion {

    public static FitnessUserDto entityToDto(FitnessUser fitnessUser){
        return new FitnessUserDto(fitnessUser.getEmail(), fitnessUser.getUsername(), fitnessUser.getPassword(),
                fitnessUser.getIndividualWorkouts(), fitnessUser.getGroupWorkouts());
    }

    public static FitnessUser dtoToEntity(FitnessUserDto fitnessUserDto){
        return new FitnessUser(fitnessUserDto.getEmail(), fitnessUserDto.getUsername(), fitnessUserDto.getPassword(),
                fitnessUserDto.getIndividualWorkouts(), fitnessUserDto.getGroupWorkouts());
    }
}
