package com.example.FitnessSystem.repository;


import com.example.FitnessSystem.model.IndividualWorkout;
import com.example.FitnessSystem.model.IndividualWorkoutId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndividualWorkoutRepository extends CrudRepository<IndividualWorkout, IndividualWorkoutId> {

}
