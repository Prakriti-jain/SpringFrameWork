package org.example.Annotations;

/*
@Value - Spring ko bolta hai ki tum value bahar se lekar aao aur inject karo
When spring creates a bean - it reads the application.properties file , resolves ${key},
takes that value to variable

@Controller - special form of @Component, used to mark a class as Spring MVC Controller,
responsible for handling web requests and returning responses. It returns HTML, json, jsp (java server pages)
and can also return data objects (string, int, etc) when @ResponseBody is used

@RestController - return data objects only (does not need any other annotation unlike controller)

@ComponentScan - is package (sub package me jaao) and jitne bhi Spring beans hai unko dhoondh kar register karlo

@Service - is a spring stereotype annotation which tells that this class is a part of service layer
and the business logic would be written here
it is actually a special form of @Component

@Component   - Generic Spring bean
@Service     - Business logic layer
@Controller  - Web layer
@Repository  - Data Access layer

@Repository - special form of @Component, interacts with the database, data access logic like CRUD operations

@Required - deprecated in spring 5 and completely removed in spring 6 - instead use Autowiring
in constructor with required = true to ensure required properties

@Scope - two types singleton and prototype
singleton - one instance is created and reused everytime it is called
prototype - har baar naya object banega everytime it is called
request - used in web apps only - @Scope("request") - ek http request ka ek bean banega and when request finishes bean is destroyed
session - used in web apps only - @Scope("session") - same as request but different use case
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
class Student{
    @Value("${Student.rollno}")
    private int rollno;

    @Value("${Student.name}")
    private String name;

    @Value("${Student.age}")
    private int age;

    public void display(){
        System.out.println(rollno + " " + name + " " + age);
    }
}

//@SpringBootApplication
public class AnnotationClass {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(AnnotationClass.class, args);
        Student stu = context.getBean(Student.class);
        stu.display();
    }
}
