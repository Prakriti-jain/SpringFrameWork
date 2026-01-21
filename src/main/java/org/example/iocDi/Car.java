package org.example.iocDi;

import org.springframework.stereotype.Component;

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
