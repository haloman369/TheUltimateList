package com.theultimatelist.services;

import com.theultimatelist.json.JokeResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JokeService {

    private static final String BASE = "http://api.icndb.com/jokes/random?limitTo=[nerdy]";

    private RestTemplate restTemplate;
    //private RestTemplate twitchRestTemplate;


    @Autowired
    public JokeService(RestTemplateBuilder builder){

        restTemplate = builder.build();
    }

    public String getJoke(String first, String last){

        String url = String.format("%s&firstName=%s&lastName=%s", BASE, first, last);

        JokeResponse response =  restTemplate.getForObject(url, JokeResponse.class);

        String output = "";

        if (response != null) {
            output = response.getValue().getJoke();

        }

        return output;

    }

//    @Autowired
//    public JokeService(RestTemplate twitchRestTemplate){
//        this.twitchRestTemplate = twitchRestTemplate;
//        restTemplate = builder.build();
//    }

//    public ResponseEntity<String> searchGames(String name) {
//        twitchRestTemplate.getWhatver(name);
//
//        return searchResponse;
//    }
}
