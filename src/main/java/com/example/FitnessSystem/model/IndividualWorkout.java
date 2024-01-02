package com.example.FitnessSystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "IndividualWorkout")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IndividualWorkout {

    @EmbeddedId
    private IndividualWorkoutId individualWorkoutId;

    @ManyToOne
    @JoinColumn(name = "email")
    private FitnessUser fitnessUser;
}
