package com.example.ec1.service;


import com.example.ec1.dto.CourseDto;
import com.example.ec1.dto.StudentCourseCountDTO;
import com.example.ec1.dto.StudentDto;
import com.example.ec1.model.Student;
import com.example.ec1  .repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import java.util.Date;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentDto> findStudentsEnrolledInCourse(String courseName) {
        List<Student> students = studentRepository.findStudentsEnrolledInCourse(courseName);

        return students.stream().map(student -> new StudentDto(
                student.getId(),
                student.getNombre(),
                student.getDateOfBirth(),
                student.getEmail(),
                student.getStudentCourses().stream()
                        .map(sc -> new CourseDto(
                                sc.getCourse().getId(),
                                sc.getCourse().getNombre(),
                                sc.getCourse().getCredit(),
                                sc.getCourse().getDescripcion()
                        ))
                        .collect(Collectors.toList())
        )).collect(Collectors.toList());
    }
    public List<StudentCourseCountDTO> countCoursesPerStudent() {
        return studentRepository.countCoursesPerStudent();
    }

    public List<StudentDto> findStudentsByBirthDate(LocalDate birthDate) {
        List<Student> students = studentRepository.findStudentsByBirthDate(birthDate);

        return students.stream().map(student -> new StudentDto(
                student.getId(),
                student.getNombre(),
                student.getDateOfBirth(),
                student.getEmail(),
                student.getStudentCourses().stream()
                        .map(sc -> new CourseDto(
                                sc.getCourse().getId(),
                                sc.getCourse().getNombre(),
                                sc.getCourse().getCredit(),
                                sc.getCourse().getDescripcion()
                        ))
                        .collect(Collectors.toList())
        )).collect(Collectors.toList());
    }

}