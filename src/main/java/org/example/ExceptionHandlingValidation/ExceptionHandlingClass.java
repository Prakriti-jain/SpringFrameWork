package org.example.ExceptionHandlingValidation;

/*
three ways to exception handling in spring boot
- default exception handling by spring boot
- using @ExceptionHandler annotation
- using @ControllerAdvice for global exception handling

Controller ka kaam = decision lena
Error handle karna = exception handler ka kaam

@ControllerAdvice - Ye saare controllers ke liye kaam karega
- Centralized error handling

Spring -
- Controller se bahar nikalta hai
- GlobalExceptionHandler dhundhta hai
- Matching @ExceptionHandler call karta hai

ResponseEntity<T> - wrapper that lets you control the entire HTTP response (status code + headers + body).

IMPORTANT --> There can be only one ControllerAdvice in one package
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

class Customer {
    private Integer id;
    private String name;
    private Integer age;

    public Customer(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

//Created a custom Exception
class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(String message) {
        super(message);
    }
}


@RestController
@RequestMapping("/customer")
class CustomerController {

    //Controller throws this exception but does not handle it
    //ControllerAdvice handles the exception

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Integer id){
        // if the Customer is not found with this id then exception will be handled.
        if(id!=1)
            throw new CustomerNotFoundException("Customer not found with id: "+id); // this will be printed if the Soldier with id other than 1 is checked.
        return new Customer(1,"Prakriti",21); //fallback, assumption for now
    }
}

//@ControllerAdvice
//class GlobalException {
//    //Agar kahin bhi CustomerNotFoundException throw ho to ye method call karo
//    //ResponseEntity<> requires HTTP Status code
//    @ExceptionHandler(CustomerNotFoundException.class)
//    public ResponseEntity<String> handleCustomerNotFound(CustomerNotFoundException ex) {
//        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
//    }
//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<String> handleGenericException(Exception ex) {
//        return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//}

@SpringBootApplication
public class ExceptionHandlingClass {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ExceptionHandlingClass.class, args);
    }
}
