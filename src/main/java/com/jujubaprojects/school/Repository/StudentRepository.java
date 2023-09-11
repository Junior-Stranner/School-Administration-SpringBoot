package com.jujubaprojects.school.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jujubaprojects.school.Model.Student;

@Repository
public interface StudentRepository extends JpaRepository <Student, Long>{
    
     List<Student> findAll();

     Student findById(long id); 

     int countById(long id);

     List<Student> findByName(String name);

     List<Student> findByNameStartsWith(String termo);

  @Query(value = "SELECT * FROM student WHERE age <= :age", nativeQuery = true)
    List<Student> ageMenorIgual(@Param("age") int age);

}
