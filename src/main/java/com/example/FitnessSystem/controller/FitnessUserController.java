package com.example.FitnessSystem.controller;


import com.example.FitnessSystem.conversions.FitnessUserConversion;
import com.example.FitnessSystem.dtos.FitnessUserDto;
import com.example.FitnessSystem.service.FitnessUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/private/api/users")
@RequiredArgsConstructor
public class FitnessUserController {

    private final FitnessUserService fitnessUserService;

    @PostMapping
    public ResponseEntity<FitnessUserDto> createFitnessUser(@RequestBody FitnessUserDto fitnessUserDto) {
        return new ResponseEntity<>(FitnessUserConversion.entityToDto(fitnessUserService
                .createUser(FitnessUserConversion.dtoToEntity(fitnessUserDto))), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<FitnessUserDto> login(@RequestParam("username") String username, @RequestParam("password") String password){
        return new ResponseEntity<>(FitnessUserConversion.entityToDto(fitnessUserService.login(username, password)), HttpStatus.OK);
    }
}
