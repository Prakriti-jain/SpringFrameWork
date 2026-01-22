package org.example.Annotations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
class UserService {
    public String getName(){
        return "Welcome! Prakriti";
    }
}

@Controller
class ControllerClass {
    final UserService serv;

    public ControllerClass(UserService serv){
        this.serv = serv;
    }

    @GetMapping("/service")
    @ResponseBody
    public String getUserService(){
        return serv.getName();
    }
}


@SpringBootApplication
public class ServiceClass {
    public static void main(String[] args) {
        SpringApplication.run(ServiceClass.class, args);
    }
}
