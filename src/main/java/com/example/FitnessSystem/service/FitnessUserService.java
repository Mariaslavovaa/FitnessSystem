package com.example.FitnessSystem.service;

import com.example.FitnessSystem.model.FitnessUser;

public interface FitnessUserService {

    FitnessUser createUser(FitnessUser fitnessUser);
    FitnessUser login(String username, String password);
}
