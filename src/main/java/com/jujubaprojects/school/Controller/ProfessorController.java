package com.jujubaprojects.school.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jujubaprojects.school.Model.Mensagem;
import com.jujubaprojects.school.Model.Professor;
import com.jujubaprojects.school.Repository.ProfessorRepository;

@RestController
public class ProfessorController {
    
    @Autowired
   private ProfessorRepository professorRepository;

    @Autowired
  private  Mensagem mensagem;

    @GetMapping("/prof/show")
    public Iterable<Professor> listar(){
        return professorRepository.findAll();
    }

    @PostMapping("/prof/create")
    public ResponseEntity<?> cadastrar(@RequestBody Professor professor){

        if(professor.getNameProfessor().equals("")){
          mensagem.setMensagem("enter the Professor´s name");
          return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(professorRepository.save(professor) , HttpStatus.CREATED);
        }

    }

    public ResponseEntity<?> showcodigo(long codigo){

        if(professorRepository.countByCodigo(codigo) == 0){
            mensagem.setMensagem(" enter a Valid code");
            return new ResponseEntity<>(mensagem , HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(professorRepository.countByCodigo(codigo), HttpStatus.OK);
        }

    }


    
}
