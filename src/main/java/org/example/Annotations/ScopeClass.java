package org.example.Annotations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("singleton")
class Singleton {

}

@Component
@Scope("prototype")
class Prototype {

}

@Component
@Scope("request")
class Request {

}

@Component
@Scope("session")
class Session {

}

@SpringBootApplication
public class ScopeClass {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ScopeClass.class, args);
        Singleton a = context.getBean(Singleton.class);
        Singleton b = context.getBean(Singleton.class);
        System.out.println(a==b);
    }
}




