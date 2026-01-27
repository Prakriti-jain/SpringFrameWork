package org.example.SpringJPA;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public void createStudent(){
        StudentEntity s1 = new StudentEntity();
        s1.setName("Adi");

        StudentEntity s2 = new StudentEntity();
        s2.setName("Rohi");

        CourseEntity dbms = new CourseEntity();
        dbms.setCourseName("DBMS");

        CourseEntity os = new CourseEntity();
        os.setCourseName("OS");

        s1.addCourse(dbms);
        s1.addCourse(os);

        repo.save(s1);
        repo.save(s2);
    }

    public List<StudentEntity> getStudentWithCourse(){
        System.out.println(repo.getEnrolledStudents());
        return repo.getEnrolledStudents();
    }

    public List<StudentEntity> getAll(){
        return repo.findAll();
    }

    public Optional<StudentEntity> getById(int id) {
        return repo.findById(id);
    }

    public StudentEntity addStudent(StudentEntity student) {
        List<CourseEntity> incomingCourses = student.getCourses();
        student.setCourses(new ArrayList<>()); // reset list
        System.out.println("hello");
        System.out.println(incomingCourses);
        if (incomingCourses != null) {
            for (CourseEntity c : incomingCourses) {
                System.out.println(c.getCourseName());
                student.addCourse(c); // VERY IMPORTANT
            }
        }

        return repo.save(student);
    }
}
