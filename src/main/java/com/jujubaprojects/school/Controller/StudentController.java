package com.jujubaprojects.school.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jujubaprojects.school.Model.Student;
import com.jujubaprojects.school.Repository.StudentRepository;
import com.jujubaprojects.school.Service.StudentService;

@RestController
public class StudentController {
    
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentService studentService;

    @GetMapping("/school/welcoming")
    public String boasVindas(){
        return "Welcome Back Kidys";

    } 

    @PostMapping("/school/registerStudent")
    public ResponseEntity<?> cadastrar(@RequestBody Student student){
        return studentService.cadastrar(student);

    }

    @GetMapping("/school/findAll")
    public ResponseEntity<?> findAll(){
        return studentService.findAll();

    }

    @GetMapping("/school/showId/{id}")
    public ResponseEntity<?> findById(@PathVariable long id){
        return studentService.showId(id);

    }

    @PutMapping("/school/toEdit/{id}")
    public ResponseEntity<?> edit(@RequestBody Student student){
        return studentService.toEdit(student);

    }

    @GetMapping("/school/beginWith")
    public List<Student> begingWitch(){
        return studentRepository.findByfirstnameStartsWith("V");

    }

    @GetMapping("/school/firstnames")
    public List<Student> firstnames(){
        return studentRepository.findByfirstname("jubu");
    }

    @DeleteMapping("/school/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        return studentService.deleteStudent(id);

    }

    @GetMapping("/school/agelike")
    public List<Student> agelike(){
        return studentRepository.ageMenorIgual(22);
    }


}
