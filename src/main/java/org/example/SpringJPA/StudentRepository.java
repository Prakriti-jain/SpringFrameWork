package org.example.SpringJPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/*
Query("") is written in JPQL which supports MySQL/PostregsSQL/H2 so Hibernate automatically
converts this to whatever database you connect it with
JPQL is database-independent (Hibernate translates it to Postgres SQL automatically)

Repository is just for connecting database to the service class
 */



public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
    // INNER JOIN (sirf enrolled students)
    @Query("SELECT s FROM StudentEntity s JOIN s.courses cs")
    List<StudentEntity> getEnrolledStudents();
}
