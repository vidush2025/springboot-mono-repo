package com.restAPIs.restAPIs.controller;

import com.restAPIs.restAPIs.dto.StudentDto;
import com.restAPIs.restAPIs.entity.Student;
import com.restAPIs.restAPIs.repository.StudentRepository;
import com.restAPIs.restAPIs.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/student")
    public List<StudentDto> getStudent(){
        return studentService.getAllStudents();
    }
}
