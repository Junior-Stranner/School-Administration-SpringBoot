package com.jujubaprojects.school.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jujubaprojects.school.Model.Mensagem;
import com.jujubaprojects.school.Model.Student;
import com.jujubaprojects.school.Repository.StudentRepository;

@Service
public class StudentService {

     @Autowired
    private Mensagem mensagem;
    
    @Autowired
    StudentRepository studentRepository;

    

    public ResponseEntity<?> cadastrar(Student student){

        if(student.getFirstname().equals("")){
            mensagem.setMensagem("enter the student's first name");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(student.getLastname().equals("")){
            mensagem.setMensagem("enter the student's last name");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(studentRepository.save(student), HttpStatus.CREATED);
        }

    }

    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(studentRepository.findAll(), HttpStatus.OK);

    }

    public ResponseEntity<?> showId(long id){
       //  Student student = studentRepository.findById();
        if(studentRepository.countById(id) == 0){
           mensagem.setMensagem("fail at try to find student !!");
           return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else{
           return new ResponseEntity<>(studentRepository.findById(id), HttpStatus.OK);
        }
    }

    public ResponseEntity<?> toEdit(Student student){
        return new ResponseEntity<>(studentRepository.save(student), HttpStatus.OK);

    }

    public ResponseEntity<?> deleteStudent(long id){

        if(studentRepository.countById(id) == 0){
            mensagem.setMensagem("enter a valid Id");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
          }else{
            Student student = studentRepository.findById(id);
             studentRepository.delete(student);

             mensagem.setMensagem("student removed successfully");
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
          }
  }
}