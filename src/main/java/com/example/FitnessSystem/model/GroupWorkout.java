package com.example.FitnessSystem.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "GroupWorkout")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupWorkout {

    @EmbeddedId
    private GroupWorkoutId groupWorkoutId;

    @Column(name = "name", nullable = true)
    private String name;

    @Column(name = "hallNumber")
    private Integer hallNumber;

    @Column(name = "description")
    private String description;

    @ManyToMany
    @JoinTable(name = "groupWorkoutUser",
                joinColumns = {@JoinColumn(name = "groupWorkoutId.date"),
                                @JoinColumn(name = "groupWorkoutId.coach")},
                inverseJoinColumns = {@JoinColumn(name = "user_email")})
    private List<FitnessUser> users;

}
