package com.example.ec1.service;

import com.example.ec1.dto.CourseDto;
import com.example.ec1.dto.StudentCourseDetailDTO;
import com.example.ec1.model.Course;
import com.example.ec1.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<CourseDto> findCoursesWithCreditGreaterThanOrEqual(int minCredit) {
        List<Object[]> results = courseRepository.findCoursesWithCreditGreaterThanOrEqual(minCredit);
        return results.stream().map(obj -> new CourseDto(
                ((Number) obj[0]).intValue(), // id
                (String) obj[1],               // name
                ((Number) obj[2]).intValue(),
                (String) obj[3])).toList();
    }

    public List<StudentCourseDetailDTO> getDetailedStudentCourseList() {
        List<Object[]> results = courseRepository.getDetailedStudentCourseList();
        return results.stream().map(obj -> new StudentCourseDetailDTO(
                (String) obj[0],                         // Nombre del estudiante
                LocalDate.parse((String) obj[1]),        // Convertir String a LocalDate
                (String) obj[2],                         // Email
                (String) obj[3]                          // Nombre del curso
        )).collect(Collectors.toList());
    }
    public Integer calculateTotalCreditsForStudent(int studentId) {
        return courseRepository.calculateTotalCreditsForStudent(studentId);
    }
}