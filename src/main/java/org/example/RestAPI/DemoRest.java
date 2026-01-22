package org.example.RestAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoRest {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DemoRest.class, args);
//        UserController us = context.getBean(UserController.class);


    }
}
