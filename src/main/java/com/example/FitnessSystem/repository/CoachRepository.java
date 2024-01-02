package com.example.FitnessSystem.repository;


import com.example.FitnessSystem.model.Coach;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoachRepository extends CrudRepository<Coach, String> {

}
