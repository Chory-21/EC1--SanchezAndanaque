package com.example.ec1.repository;

import com.example.ec1.dto.StudentCourseDetailDTO;
import com.example.ec1.model.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentCourseRepository extends JpaRepository<StudentCourse, Integer> {

    // Consulta Nativa: Listado Detallado de Estudiantes y sus Cursos
    @Query(value = "SELECT s.nombre, s.date_of_birth, s.email, c.nombre " +
            "FROM students s " +
            "JOIN student_courses sc ON s.id = sc.student_id " +
            "JOIN courses c ON sc.course_id = c.id", nativeQuery = true)
    List<Object[]> getStudentCourseDetails();

    // Consulta Nativa: Cálculo del Total de Créditos de un Estudiante
    @Query(value = "SELECT COALESCE(SUM(c.credit), 0) " +
            "FROM courses c " +
            "JOIN student_courses sc ON c.id = sc.course_id " +
            "WHERE sc.student_id = :studentId", nativeQuery = true)
    Integer calculateTotalCreditsForStudent(@Param("studentId") Integer studentId);
}