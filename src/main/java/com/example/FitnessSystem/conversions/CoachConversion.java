package com.example.FitnessSystem.conversions;

import com.example.FitnessSystem.dtos.CoachDto;
import com.example.FitnessSystem.model.Coach;
import com.example.FitnessSystem.model.IndividualWorkout;
import lombok.experimental.UtilityClass;

import java.util.stream.Collectors;

@UtilityClass
public class CoachConversion {

//    public static CoachDto entityToDto(Coach coach){
//        return new CoachDto(coach.getEmail(), coach.getUsername(), coach.getPhoneNumber(), coach.getEducation(),
//                coach.getProfessionalExperience(), coach.getIndividualWorkouts().stream().map(IndividualWorkoutConversion::entityToDto).toList(),
//                coach.getGroupWorkouts().stream().map(GroupWorkoutConversion::entityToDto).toList());
//    }

//    public static Coach dtoToEntity(CoachDto coachDto){
//        return new Coach(coachDto.getEmail(), coachDto.getUsername(), coachDto.getPhoneNumber(), coachDto.getEducation(),
//                coachDto.getProfessionalExperience(), coachDto.getIndividualWorkouts().stream().map(IndividualWorkoutConversion::dtoToEntity).collect(Collectors.toList()),
//                coachDto.getGroupWorkouts().stream().map(GroupWorkoutConversion::dtoToEntity).collect(Collectors.toList()));
//    }
}
