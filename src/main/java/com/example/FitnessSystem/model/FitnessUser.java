package com.example.FitnessSystem.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name = "FitnessUser")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FitnessUser {

    @Id
    private String email;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany(mappedBy = "fitnessUser")
    private List<IndividualWorkout> individualWorkouts;

    @ManyToMany(mappedBy = "users")
    private List<GroupWorkout> groupWorkouts;
}
