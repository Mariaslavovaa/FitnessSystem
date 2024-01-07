package com.example.FitnessSystem.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FitnessUserDto {

    private String email;
    private String username;
    private String password;

    private List<IndividualWorkoutDto> individualWorkouts;
    private List<GroupWorkoutDto> groupWorkouts;
}
