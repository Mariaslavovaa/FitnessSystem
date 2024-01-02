package com.example.FitnessSystem.conversions;


import com.example.FitnessSystem.dtos.IndividualWorkoutDto;
import com.example.FitnessSystem.model.IndividualWorkout;
import com.example.FitnessSystem.model.IndividualWorkoutId;
import lombok.experimental.UtilityClass;

@UtilityClass
public class IndividualWorkoutConversion {

    public static IndividualWorkoutDto entityToDto(IndividualWorkout individualWorkout){
        return new IndividualWorkoutDto(individualWorkout.getIndividualWorkoutId().getLocalDateTime(),
                CoachConversion.entityToDto(individualWorkout.getIndividualWorkoutId().getCoach()),
                FitnessUserConversion.entityToDto(individualWorkout.getFitnessUser()));
    }

    public static IndividualWorkout dtoToEntity(IndividualWorkoutDto individualWorkoutDto){
        return new IndividualWorkout(new IndividualWorkoutId(individualWorkoutDto.getLocalDateTime(),
                CoachConversion.dtoToEntity(individualWorkoutDto.getCoach())),
                FitnessUserConversion.dtoToEntity(individualWorkoutDto.getFitnessUser()));
    }
}
