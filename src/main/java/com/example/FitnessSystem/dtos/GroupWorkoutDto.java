package com.example.FitnessSystem.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupWorkoutDto {

    @JsonFormat(pattern = "M/dd/yyyy HH:mm:ss")
    private LocalDateTime date;
    private String coach;
    private String name;
    private Integer hallNumber;
    private String description;
    private List<String> users;
}
