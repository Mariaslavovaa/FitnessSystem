package com.example.FitnessSystem.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class IndividualWorkoutDto {

    @JsonFormat(pattern = "M/dd/yyyy HH:mm:ss")
    private LocalDateTime localDateTime;
    private String coach;
    private String fitnessUser;
}
