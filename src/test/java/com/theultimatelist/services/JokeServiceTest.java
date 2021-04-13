package com.theultimatelist.services;



import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class JokeServiceTest {

    private Logger logger = LoggerFactory.getLogger(JokeServiceTest.class);

    @Autowired
    private JokeService service;

    @Autowired
    private ApplicationContext ctx;//does spring have ApplicationContext laying around

    @Test
    public void contextLoads() {

        int count = ctx.getBeanDefinitionCount();
        System.out.println("There are " + count + " beans in the application context");
        for (String name : ctx.getBeanDefinitionNames()) {
            System.out.println(name);
        }

    }


    @Test
    public void getJoke(){

        System.out.println(service.getClass());

        String joke = service.getJoke("Dan", "Drechsel");

        logger.info(joke);
        assertTrue(joke.contains("Dan") || joke.contains("Drechsel"));

    }

}