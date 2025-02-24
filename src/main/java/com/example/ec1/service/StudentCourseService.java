package com.example.ec1.service;

import com.example.ec1.dto.StudentCourseDetailDTO;
import com.example.ec1.repository.StudentCourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentCourseService {

    private final StudentCourseRepository studentCourseRepository;

    public StudentCourseService(StudentCourseRepository studentCourseRepository) {
        this.studentCourseRepository = studentCourseRepository;
    }

    // Obtener lista detallada de estudiantes y sus cursos


    // Obtener el total de créditos de un estudiante

}