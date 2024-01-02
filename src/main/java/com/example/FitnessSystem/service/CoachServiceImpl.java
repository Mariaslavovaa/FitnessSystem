package com.example.FitnessSystem.service;

import com.example.FitnessSystem.model.Coach;
import com.example.FitnessSystem.repository.CoachRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CoachServiceImpl implements CoachService{

    private final CoachRepository coachRepo;

    @Override
    public List<Coach> getAllCoaches() {
        List<Coach> coaches = new ArrayList<>();
        coachRepo.findAll().forEach(coaches::add);
        return coaches;
    }
}
