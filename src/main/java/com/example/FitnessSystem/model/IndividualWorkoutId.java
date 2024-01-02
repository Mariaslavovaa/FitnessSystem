package com.example.FitnessSystem.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
@Data
public class IndividualWorkoutId implements Serializable {

    @Column(name = "date", nullable = false)
    @JsonFormat(pattern="yyyy/MM/dd HH:mm:ss")
    private LocalDateTime localDateTime;

    @ManyToOne
    @JoinColumn(name = "coach_email", referencedColumnName = "email")
    private Coach coach;

}
