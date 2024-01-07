package com.example.FitnessSystem.service;


import com.example.FitnessSystem.dtos.GroupWorkoutDto;
import com.example.FitnessSystem.model.Coach;
import com.example.FitnessSystem.model.FitnessUser;
import com.example.FitnessSystem.model.GroupWorkout;
import com.example.FitnessSystem.model.GroupWorkoutId;
import com.example.FitnessSystem.repository.CoachRepository;
import com.example.FitnessSystem.repository.FitnessUserRepository;
import com.example.FitnessSystem.repository.GroupWorkoutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupWorkoutServiceImpl implements GroupWorkoutService {

    private final GroupWorkoutRepository groupWorkoutRepo;
    private final CoachRepository coachRepository;
    private final FitnessUserRepository fitnessUserRepository;

    @Override
    public GroupWorkoutDto createGroupWorkout(GroupWorkoutDto groupWorkout) {
       GroupWorkout toSave = new GroupWorkout();
       Coach foundCoach = coachRepository.findByEmail(groupWorkout.getCoach()).orElseThrow();
       List<FitnessUser> users = new ArrayList<>();
       if(groupWorkout.getUsers() != null){
           groupWorkout.getUsers().forEach(user -> {
               FitnessUser foundUser = fitnessUserRepository.findByEmail(user).orElseThrow();
               users.add(foundUser);
           });
       }

       toSave.setGroupWorkoutId(new GroupWorkoutId(groupWorkout.getDate(), foundCoach));
       toSave.setDescription(groupWorkout.getDescription());
       toSave.setName(groupWorkout.getName());
       toSave.setHallNumber(groupWorkout.getHallNumber());
       toSave.setUsers(users);

       groupWorkoutRepo.save(toSave);
       return groupWorkout;
    }

    @Override
    public void deleteGroupWorkoutById(GroupWorkoutId groupWorkoutId) {
        groupWorkoutRepo.deleteById(groupWorkoutId);
    }

    @Override
    public List<GroupWorkout> getAllGroupWorkouts() {
        List<GroupWorkout> groupWorkouts = new ArrayList<>();
        groupWorkoutRepo.findAll().forEach(groupWorkouts::add);
        return groupWorkouts;
    }
}
