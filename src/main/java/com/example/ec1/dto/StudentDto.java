package com.example.ec1.dto;

import java.time.LocalDate;
import java.util.List;

public class StudentDto {
    private Integer id;
    private String nombre;
    private LocalDate dateOfBirth;

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    private String email;
    private List<CourseDto> studentCourse;

    public StudentDto(Integer id, String nombre,LocalDate dateOfBirth , String email, List<CourseDto> studentCourse) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.studentCourse = studentCourse;
        this.dateOfBirth=dateOfBirth;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<CourseDto> getStudentCourse() {
        return studentCourse;
    }

    public void setStudentCourses(List<CourseDto> studentCourse) {
        this.studentCourse = studentCourse;
    }
}

