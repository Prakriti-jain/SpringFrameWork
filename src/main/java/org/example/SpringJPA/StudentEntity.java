package org.example.SpringJPA;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "student")
public class StudentEntity {
    @Id
    private int id;
    private String name;

    @OneToMany(mappedBy = "student")
    private List<CourseEntity> courses = new ArrayList<>();


    public StudentEntity(){
    }

    public StudentEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CourseEntity> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseEntity> courses) {
        this.courses = courses;
    }

    public void addCourse(CourseEntity cs) {
        courses.add(cs); //course added to the list, but now we have to map this student in the Course Table
        cs.setStudent(this); //mapped this student in the Course Table also
    }
}
