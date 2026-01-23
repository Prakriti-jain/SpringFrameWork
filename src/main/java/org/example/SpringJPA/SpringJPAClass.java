package org.example.SpringJPA;

/*
Spring data JPA - Java Persistence API - is a framework, and it makes working with databases easy
We don't need to write SQL Queries or JDBC Code (Java Database Connectivity), just call java methods
and work will be done!
Works only for relational database.

Controller -> Service -> Repository -> Database

@Repository - Spring ko batata hai ye DB layer hai
JpaRepository -> Ready made DB methods deta hai, jisse SQL queries likhne ki zaroorat nahi padhti
- save() - insert or update ; if id is present then update, if not then insert
- findById() - id se record laata hai ; return type Optional<>
- findAll() - puri table ka data
- deleteById() - id se delete

Table <--> Java Object Mapping happens through Entity class @Entity

Query("sql query") to give sql queries directly

--------------------------------------------------------------------------------------------
- in student table
@OneToMany(mappedBy="student")
private List<Enrollment> enrollments;
- one student can have multiple enrollments - but foreign is not in student table
- Student side pe list hogi
- But foreign key student table me nahi, Enrollment table me hoti hai (kyunki enrollment ko pata hona chahiye “ye kis student ka hai)

----------------------------------------------------------------------------------------------
- in enrollment table
@ManyToOne
@JoinColumn(name="student_id")
private Student student;
- many enrollments can point to one student
- Join column indicates ki student_id foreign key hai in enrollment table


✅ @JoinColumn = FK creates
✅ mappedBy = FK already exists there


Relation	             Foreign key kaha banti hai?
ManyToOne	             ✅ Many side table me
OneToMany(mappedBy)	     ❌ FK create nahi karta
OneToOne	             ✅ Jis side @JoinColumn
ManyToMany	             ✅ Join table me 2 FK
*/


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJPAClass {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringJPAClass.class, args);
    }

}
