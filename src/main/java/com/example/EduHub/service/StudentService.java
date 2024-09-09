package com.example.EduHub.service;

import com.example.EduHub.model.StudentModel;

import java.util.List;
import java.util.UUID;

public interface StudentService {
    List<StudentModel> findAllStudent();
    StudentModel createStudent(StudentModel student);
    StudentModel updateStudent(StudentModel student);
    StudentModel findStudentById(UUID id);
    void deleteStudent(UUID id);
}
