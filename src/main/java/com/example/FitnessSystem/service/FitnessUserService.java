package com.example.FitnessSystem.service;

import com.example.FitnessSystem.dtos.FitnessUserDto;
import com.example.FitnessSystem.model.FitnessUser;

public interface FitnessUserService {

    FitnessUserDto createUser(FitnessUserDto fitnessUser);
    FitnessUserDto login(String username, String password);
    FitnessUser findByUsername(String username);
}
