package com.example.FitnessSystem.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Coach")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coach {

    @Id
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "education")
    private String education;

    @Column(name = "professional_experience")
    private String professionalExperience;

    @OneToMany(mappedBy = "individualWorkoutId.coach")
    @JsonIgnore
    private List<IndividualWorkout> individualWorkouts;

    @OneToMany(mappedBy = "groupWorkoutId.coach")
    @JsonIgnore
    private List<GroupWorkout> groupWorkouts;

}
