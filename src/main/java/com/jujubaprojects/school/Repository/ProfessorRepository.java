package com.jujubaprojects.school.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jujubaprojects.school.Model.Professor;


@Repository
public interface ProfessorRepository  extends JpaRepository <Professor, Long>{
    
     List<Professor> findAll();

     Professor findByCodigo(long codigo); 

    int countByCodigo(long codigo);
}
