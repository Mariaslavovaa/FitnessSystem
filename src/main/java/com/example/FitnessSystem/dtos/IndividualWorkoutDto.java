package com.example.FitnessSystem.dtos;

import com.example.FitnessSystem.model.FitnessUser;
import com.example.FitnessSystem.model.IndividualWorkoutId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class IndividualWorkoutDto {

    private LocalDateTime localDateTime;
    private CoachDto coach;
    private FitnessUserDto fitnessUser;
}
