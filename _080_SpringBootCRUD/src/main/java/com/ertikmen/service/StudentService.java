package com.ertikmen.service;

import com.ertikmen.model.Student;
import com.ertikmen.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student getOneStudent(Long id) {
        return studentRepository.findById(id).get();
    }
}
