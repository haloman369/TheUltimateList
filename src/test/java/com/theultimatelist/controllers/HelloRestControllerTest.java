package com.theultimatelist.controllers;


import com.theultimatelist.entities.Greeting;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)//start web server on some random port
public class HelloRestControllerTest {

    @Autowired
    private TestRestTemplate template;

    @Test
    public void greetWithoutName(){
        ResponseEntity<Greeting> entity = template.getForEntity("/rest", Greeting.class);
        //getForEntity returns the entire HTTP response object, can check status code, headers, content type, etc
        assertEquals(HttpStatus.OK, entity.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON, entity.getHeaders().getContentType());
        Greeting response = entity.getBody();
        assertEquals("Hello, World!", response.getMessage());
    }

    @Test
    public void greetWithName(){
        Greeting response = template.getForObject("/rest?name=Dan", Greeting.class);
        //template has method getForObject takes a URL and the class to convert the resulting JSON into arguments
        assertEquals("Hello, Dan!", response.getMessage());
    }

}
