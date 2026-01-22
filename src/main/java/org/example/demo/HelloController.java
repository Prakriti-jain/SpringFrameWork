
package org.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {

//    will run directly when @RestController is used

//    @GetMapping("/hello")
//    public String hello() {
//        return "Hello, Spring!";
//    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello(Model model) {
//        model.addAttribute("message","helloo!" ); //for this need to create an html in resource/template/file.html
        return "hello0000";
    }

}