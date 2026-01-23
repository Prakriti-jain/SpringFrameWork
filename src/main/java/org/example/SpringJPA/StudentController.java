package org.example.SpringJPA;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stu")
public class StudentController {
    private StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping("/seed")
    public String seed() {
        service.createStudent();
        return "Data inserted ✅";
    }

    @GetMapping("/getall")
    public List<StudentEntity> getAll(){
        return service.getAll();
    }

    @GetMapping("/getEn")
    public List<StudentEntity> getEnrolled(){
        return service.getStudentWithCourse();
    }
}
