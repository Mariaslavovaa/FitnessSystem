package com.example.FitnessSystem.repository;


import com.example.FitnessSystem.model.GroupWorkout;
import com.example.FitnessSystem.model.GroupWorkoutId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupWorkoutRepository extends CrudRepository<GroupWorkout, GroupWorkoutId> {

}
