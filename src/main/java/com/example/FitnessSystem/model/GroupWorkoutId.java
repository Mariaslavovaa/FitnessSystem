package com.example.FitnessSystem.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
@Data
public class GroupWorkoutId implements Serializable {

    @JsonFormat(pattern="yyyy/MM/dd HH:mm:ss")
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "email", referencedColumnName = "email")
    @JsonManagedReference
    private Coach coach;
}
