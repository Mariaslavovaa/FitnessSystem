package com.example.FitnessSystem.dtos;

import com.example.FitnessSystem.model.GroupWorkout;
import com.example.FitnessSystem.model.IndividualWorkout;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoachDto {

    private String email;
    private String username;
    private String phoneNumber;
    private String education;
    private String professionalExperience;

    private List<IndividualWorkout> individualWorkouts;
    private List<GroupWorkout> groupWorkouts;
}
