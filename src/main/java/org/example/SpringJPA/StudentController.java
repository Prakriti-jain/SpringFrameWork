package org.example.SpringJPA;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public Optional<StudentEntity> getById(@PathVariable int id){
        return service.getById(id);
    }

    @PostMapping
    public StudentEntity addStudent(@RequestBody StudentEntity student) {
        return service.addStudent(student);
    }

}
