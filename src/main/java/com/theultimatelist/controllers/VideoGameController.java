package com.theultimatelist.controllers;

import com.theultimatelist.services.TwitchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VideoGameController {

//    private final JokeService jokeService;
//
//    @Autowired
//    public VideoGameController(JokeService jokeService) {
//        this.jokeService = jokeService;
//    }

//    @GetMapping("/search")
//    public ResponseEntity<String> searchGames(@RequestParam String name) {
//        ResponseEntity<String> response = jokeService.searchGames(name);
//
//        return response;
    private final TwitchService twitchService;

    @Autowired
    public VideoGameController(TwitchService twitchService){

        this.twitchService = twitchService;

    }

    @GetMapping("/halo")
    public ResponseEntity<String> searchGames(@RequestParam String name) {

        List<String> response = twitchService.getGames(name);

        return new ResponseEntity<String>(String.join(",",response), HttpStatus.OK);
    }


}
