package com.theultimatelist.controllers;


import com.theultimatelist.services.DogBreedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DogContoller {

    private final DogBreedService dogBreedService;

    @Autowired
    public DogContoller(DogBreedService dogBreedService){

        this.dogBreedService = dogBreedService;

    }

    @GetMapping("/dog")
    public ResponseEntity<String> searchDog(@RequestParam String name){

        String response = dogBreedService.getBreedName(name);

        return new ResponseEntity<String>(response, HttpStatus.OK);
    }



}
