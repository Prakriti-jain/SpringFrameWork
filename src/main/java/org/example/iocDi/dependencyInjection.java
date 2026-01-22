package org.example.iocDi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/*
two types of String dependency -
- Setter Dependency - involves injecting dependencies via setter methods, @Autowiredis used
- Constructor Dependency -
- @Autowired - Spring container se required bean ko automatically inject karta hai
- used in constructor injection in setter but not for fields

Configuration class - tells the spring to scan the given package with the annotations
to make beans
 */

interface IEngine {
    void start();
}

@Component
@Qualifier("toyo")
class ToyotaEngine implements IEngine {

    @Override
    public void start() {
        System.out.println("Toyota engine starts");
    }
}

@Component
@Primary
class BMWEngine implements IEngine {

    @Override
    public void start() {
        System.out.println("BMW engine starts");
    }
}

@Component
class Vehicle {
    IEngine eng; //field injection

    @Autowired
    Vehicle(@Qualifier("toyo") IEngine eng) { //constructor injection
        this.eng = eng;
    }

    void setEng(IEngine eng) { // setter injection
        this.eng = eng;
    }

    void drive(){
        eng.start();
        System.out.println("Vehicle starts driving");
    }
}

@Configuration
@ComponentScan(basePackages = "org.example.iocDi")
class ConfigurationClass{

}

public class dependencyInjection {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationClass.class);
        Vehicle vehicle1 = (Vehicle) context.getBean(Vehicle.class);
        vehicle1.drive();
    }
}
