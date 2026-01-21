
package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
The Application class starts Spring
The Controller class handles HTTP requests
 */


@SpringBootApplication  // enables component scan + auto-configuration
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
