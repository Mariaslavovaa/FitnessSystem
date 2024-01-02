package com.example.FitnessSystem.conversions;

import com.example.FitnessSystem.dtos.CoachDto;
import com.example.FitnessSystem.model.Coach;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CoachConversion {

    public static CoachDto entityToDto(Coach coach){
        return new CoachDto(coach.getEmail(), coach.getUsername(), coach.getPhoneNumber(), coach.getEducation(),
                coach.getProfessionalExperience(), coach.getIndividualWorkouts(), coach.getGroupWorkouts());
    }

    public static Coach dtoToEntity(CoachDto coachDto){
        return new Coach(coachDto.getEmail(), coachDto.getUsername(), coachDto.getPhoneNumber(), coachDto.getEducation(),
                coachDto.getProfessionalExperience(), coachDto.getIndividualWorkouts(), coachDto.getGroupWorkouts());
    }
}
