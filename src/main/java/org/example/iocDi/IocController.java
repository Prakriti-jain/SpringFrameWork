package org.example.iocDi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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


@RestController
public class IocController {
    Car car;
    public IocController(Car car) {
        this.car = car;
    }

    @GetMapping("/car")
    public String start() {
        return car.startCar();
    }
}
