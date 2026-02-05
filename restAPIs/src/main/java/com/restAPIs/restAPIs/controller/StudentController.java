package com.restAPIs.restAPIs.controller;

import com.restAPIs.restAPIs.dto.StudentDto;
import com.restAPIs.restAPIs.entity.Student;
import com.restAPIs.restAPIs.repository.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class StudentController {
    private final StudentRepository studentRepository;
    public StudentController(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @GetMapping("/student")
    public List<Student> getStudent(){
        return studentRepository.findAll();
    }
}
