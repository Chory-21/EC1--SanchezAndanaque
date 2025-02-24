package com.example.ec1.controller;

import com.example.ec1.dto.CourseDto;
import com.example.ec1.dto.StudentCourseDetailDTO;
import com.example.ec1.exception.CourseNotFoundException;
import com.example.ec1.model.Course;
import com.example.ec1.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/courses")
@RestController
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/by-credit/{minCredit}")
    public ResponseEntity<List<CourseDto>> getCoursesByMinimumCredit(@PathVariable int minCredit) {
        List<CourseDto> courses = courseService.findCoursesWithCreditGreaterThanOrEqual(minCredit);
        if (courses.isEmpty()) {
            throw new CourseNotFoundException("No se encontraron cursos con al menos \" + minCredit + \" créditos.");
        }
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/detailed-list")
    public ResponseEntity<List<StudentCourseDetailDTO>> getDetailedStudentCourseList() {
        List<StudentCourseDetailDTO> details = courseService.getDetailedStudentCourseList();
        if (details.isEmpty()) {
            throw new CourseNotFoundException("No se encontraron datos detallados de cursos y estudiantes.");
        }
        return ResponseEntity.ok(details);
    }

    @GetMapping("/total-credits/{studentId}")
    public ResponseEntity<Integer> getTotalCreditsForStudent(@PathVariable int studentId) {
        Integer totalCredits = courseService.calculateTotalCreditsForStudent(studentId);
        if (totalCredits == null || totalCredits == 0) {
            throw new CourseNotFoundException("No se encontraron cursos para el estudiante con ID: " + studentId);
        }
        return ResponseEntity.ok(totalCredits);
    }
}
