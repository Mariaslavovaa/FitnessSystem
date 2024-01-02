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
public class FitnessUserDto {

    private String email;
    private String username;
    private String password;

    private List<IndividualWorkout> individualWorkouts;
    private List<GroupWorkout> groupWorkouts;
}
