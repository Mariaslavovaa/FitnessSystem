package com.example.FitnessSystem.repository;

import com.example.FitnessSystem.model.FitnessUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FitnessUserRepository extends CrudRepository<FitnessUser, String> {
    Optional<FitnessUser> findByUsernameAndPassword(String username, String password);
}
