package org.example.ExceptionHandlingValidation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

//Created a custom exception
class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}

class Student {
    private Integer id;
    private String name;
    private Integer age;

    public Student(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}


@RestController
@RequestMapping("/stud")
class StudentController {
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Integer id) {

        // Validation first
        if (id <= 0) {
            throw new IllegalArgumentException("Custom exception: ID must be > 0");
        }


        if (id != 1) {
            throw new ResourceNotFoundException(
                    "Custom exception: Student not found with id: " + id
            );
        }

        return new Student(id, "Prakriti", 21);
    }
}

@SpringBootApplication
public class GlobalExceptionHandling {
    public static void main(String[] args) {
        SpringApplication.run(GlobalExceptionHandling.class, args);
    }
}

