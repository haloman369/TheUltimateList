package com.theultimatelist.services;


import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
public class DogBreedServiceTest {

    private org.slf4j.Logger logger = LoggerFactory.getLogger(DogBreedService.class);


    @Autowired
    private DogBreedService service;

    @Test
    public void getBreedName(){

        String dog = service.getBreedName("husky");

        logger.info(dog);

        assertTrue(dog.contains("Husky"));

    }

}
