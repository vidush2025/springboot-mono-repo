package com.restAPIs.restAPIs.service;

import com.restAPIs.restAPIs.dto.StudentDto;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface StudentService {

    List<StudentDto> getAllStudents();
    StudentDto getStudentById(@PathVariable Long id);
}
