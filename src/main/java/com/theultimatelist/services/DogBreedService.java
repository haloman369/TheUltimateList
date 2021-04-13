package com.theultimatelist.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.theultimatelist.json.BreedsInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DogBreedService {

    private static final String BASE = "https://api.thedogapi.com/v1/breeds/search";

    private Logger logger = LoggerFactory.getLogger(DogBreedService.class);

    private RestTemplate restTemplate;

    @Autowired
    public DogBreedService(RestTemplateBuilder builder){

        restTemplate = builder.build();

    }

    public String getBreedName(String name){

        String url = String.format("%s?q=%s",BASE,name);

        String output = "";

        System.out.println(url);

       //Breeds response = restTemplate.getForObject(url,Breeds.class);
        String response = restTemplate.getForObject(url,String.class);

        final ObjectMapper objectMapper = new ObjectMapper();
        try{

            BreedsInfo[] dogs = objectMapper.readValue(response, BreedsInfo[].class);
            output =  dogs[0].getName() + " " + dogs[0].getReference_image_id();

            System.out.println(dogs[0].getName());

        }
        catch(Exception e){

            logger.info(response);
            logger.error("Error: {}",e);


        }
        return output;
    }





}
