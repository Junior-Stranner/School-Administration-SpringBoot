package com.jujubaprojects.school.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "professores")
public class Professor {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long codigo;

    private String nameProfessor;
    


    public Professor(){

    }

    public Professor(long codigo, String nameProfessor) {
        this.codigo = codigo;
        this.nameProfessor = nameProfessor;
    }
    public long getCodigo() {
        return codigo;
    }
    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }
    public String getNameProfessor() {
        return nameProfessor;
    }
    public void setNameProfessor(String nameProfessor) {
        this.nameProfessor = nameProfessor;
    }


    

}
