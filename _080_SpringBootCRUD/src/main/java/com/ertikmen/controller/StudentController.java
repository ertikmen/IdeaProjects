package com.ertikmen.controller;


import com.ertikmen.model.Student;
import com.ertikmen.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    @Autowired
    StudentService studentService;


    // http://localhost:8080/api/v1/students

    @GetMapping("/students")
    public List<Student> findAll(){
        return studentService.findAll();
    }

    // http://localhost:8080/api/v1/students/1
    @GetMapping("/students/{id}")
    public Student getOneStudent(@PathVariable(value = "id") Long id){
        return studentService.getOneStudent(id);
    }

}
