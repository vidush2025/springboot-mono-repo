package com.restAPIs.restAPIs.service.implementation;

import com.restAPIs.restAPIs.dto.StudentDto;
import com.restAPIs.restAPIs.entity.Student;
import com.restAPIs.restAPIs.repository.StudentRepository;
import com.restAPIs.restAPIs.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

//import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImplementation implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public List<StudentDto> getAllStudents(){
        List<Student> students = studentRepository.findAll();

//        List<StudentDto> studentDtoList = new ArrayList<>();
//        for(Student student : students){
//            StudentDto studentDto = new StudentDto(
//                    student.getId(),
//                    student.getName(),
//                    student.getEmail()
//            );
//
//            studentDtoList.add(studentDto);
//        }
        //stream is used to convert any Collection A to any different Collection B
        List<StudentDto> studentDtoList = students.stream()
                .map(student -> new StudentDto(student.getId(), student.getName(), student.getEmail()))
                .toList();
        return studentDtoList;
    }
}
