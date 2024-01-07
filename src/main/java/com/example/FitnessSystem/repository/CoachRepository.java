package com.example.FitnessSystem.repository;


import com.example.FitnessSystem.model.Coach;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CoachRepository extends CrudRepository<Coach, String> {
    Optional<Coach> findByUsername(String username);
    Optional<Coach> findByEmail(String email);
}
