package com.example.FitnessSystem.dtos;

import com.example.FitnessSystem.model.Coach;
import com.example.FitnessSystem.model.FitnessUser;
import com.example.FitnessSystem.model.GroupWorkoutId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupWorkoutDto {

    private LocalDateTime date;
    private CoachDto coach;
    private String name;
    private Integer hallNumber;
    private String description;

    private List<FitnessUserDto> users;

}
