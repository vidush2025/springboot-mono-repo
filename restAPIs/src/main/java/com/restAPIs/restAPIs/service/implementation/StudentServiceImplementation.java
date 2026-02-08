package com.restAPIs.restAPIs.service.implementation;

import com.restAPIs.restAPIs.dto.StudentDto;
import com.restAPIs.restAPIs.entity.Student;
import com.restAPIs.restAPIs.repository.StudentRepository;
import com.restAPIs.restAPIs.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

//import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImplementation implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;


    @Override
    public List<StudentDto> getAllStudents(){
        List<Student> students = studentRepository.findAll();

        //stream is used to convert any Collection A to any different Collection B
        List<StudentDto> studentDtoList = students.stream()
                .map(student -> modelMapper.map(student, StudentDto.class))
                .toList();

        return studentDtoList;
    }

    @Override
    public StudentDto getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(
                        () -> new IllegalArgumentException(
                                "Student not found with Id: " + id
                        )
                );

        return modelMapper.map(student, StudentDto.class);
    }
}
