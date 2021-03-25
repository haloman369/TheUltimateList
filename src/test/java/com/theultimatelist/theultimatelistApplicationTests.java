package com.theultimatelist;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class theultimatelistApplicationTests {

    @Autowired
    private ApplicationContext ctx;//does spring have ApplicationContext laying around

    @Test
    public void contextLoads(){

        int count = ctx.getBeanDefinitionCount();
        System.out.println("There are " + count + " beans in the application context");
        for(String name : ctx.getBeanDefinitionNames()){
            System.out.println(name);
        }


    }


}
