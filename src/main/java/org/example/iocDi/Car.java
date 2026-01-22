package org.example.iocDi;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
IoC is Inversion of Control - we do not need to create and manage objects ourselves, Spring creates and manages them for us

Spring uses a special container called the IoC Container.
This container:
 - Scans your project
 - Finds classes annotated with: @Component @Service @Repository @Controller
 - Creates objects (Beans - A bean is any class whose object is created and managed by Spring’s IoC container.)
 - Injects dependencies
 - Stores all beans in a map (key → value)
 - Manages their lifecycle - instantiation, initialization, deletion etc

Controller → receives request
Service → contains business logic
Repository → DB operations

/*
Start app (SpringApplication.run(...)).
Component scan finds Engine, Car, and IocController.
Spring creates one Engine bean.
Spring creates one Car bean and injects the same Engine into its constructor.
Spring creates one IocController bean and injects the same Car into its constructor.
When GET /car hits, Spring calls IocController.start() → car.startCar().

Lazy Initialisation - @lazy - beans will be created only when there is a need not when
the application starts running.

//on creating objects as beans on the starting of the application, runtime becomes fast.

 */



@Component
class Engine { }


@Component
public class Car {
    //Car uses Engine (DI)
    private final Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public String startCar() {
        return "Started the car!";
    }
}



@RestController
class IocController {
    Car car;
    public IocController(Car car) {
        this.car = car;
    }

    @GetMapping("/car")
    public String start() {
        return car.startCar();
    }
}
