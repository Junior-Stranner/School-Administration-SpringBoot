package com.jujubaprojects.school.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jujubaprojects.school.Model.Student;

@Repository
public interface StudentRepository extends CrudRepository <Student, Long>{
    
     List<Student> findAll();

     Student findById(long id); 

     int countById(long id);

     List<Student> findByfirstname(String firstname);

     List<Student> findByfirstnameStartsWith(String termo);

  @Query(value = "SELECT * FROM student WHERE age <= :age", nativeQuery = true)
    List<Student> ageMenorIgual(@Param("age") int idageade);

}
