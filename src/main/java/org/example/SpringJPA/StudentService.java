package org.example.SpringJPA;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public void createStudent(){
        StudentEntity s1 = new StudentEntity(1, "Adi");
        StudentEntity s2 = new StudentEntity(2, "Rohi");

        s1.addCourse(new CourseEntity(1, "DBMS"));
        s1.addCourse(new CourseEntity(2, "OS"));

        repo.save(s1);
        repo.save(s2);
    }

    public List<StudentEntity> getStudentWithCourse(){
        return repo.getEnrolledStudents();
    }

    public List<StudentEntity> getAll(){
        return repo.findAll();
    }
}
