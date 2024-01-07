package com.example.FitnessSystem.controller;

import com.example.FitnessSystem.dtos.FitnessUserDto;
import com.example.FitnessSystem.service.FitnessUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/private/api/users")
@RequiredArgsConstructor
@CrossOrigin
@Log4j2
public class FitnessUserController {

    private final FitnessUserService fitnessUserService;

    @PostMapping
    public ResponseEntity<FitnessUserDto> createFitnessUser(@RequestBody FitnessUserDto fitnessUserDto) {
        return new ResponseEntity<>(fitnessUserService.createUser(fitnessUserDto), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<FitnessUserDto> login(@RequestParam("username") String username, @RequestParam("password") String password){
        return new ResponseEntity<>(fitnessUserService.login(username, password), HttpStatus.OK);
    }
}
