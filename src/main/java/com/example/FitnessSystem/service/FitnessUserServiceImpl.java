package com.example.FitnessSystem.service;


import com.example.FitnessSystem.model.FitnessUser;
import com.example.FitnessSystem.repository.FitnessUserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FitnessUserServiceImpl implements FitnessUserService{

    private final FitnessUserRepository fitnessUserRepo;

    @Override
    public FitnessUser createUser(FitnessUser fitnessUser) {
        if (fitnessUser == null){
            throw new IllegalArgumentException("User cannot be null!");
        }
        return fitnessUserRepo.save(fitnessUser);
    }

    @Override
    public FitnessUser login(String username, String password) {
        return fitnessUserRepo.findByUsernameAndPassword(username.trim(), password.trim())
                .orElseThrow(EntityNotFoundException::new);
    }
}
