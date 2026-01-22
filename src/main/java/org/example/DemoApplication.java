
package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
The Application class starts Spring
The Controller class handles HTTP requests
 */


//MAKING CONTROLLER IN MAIN

//RestController
//@SpringBootApplication
//public class Controller {
//    public static void main(String[] args) {
//        SpringApplication.run(Controller.class, args);
//    }
//
//    @Controller
//    static class Homepage {
//        @GetMapping("/hello")
//        @ResponseBody
//        public String hello(){
//            return "Vishal here!";
//        }
//    }
//}
@SpringBootApplication  // enables component scan + auto-configuration
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
