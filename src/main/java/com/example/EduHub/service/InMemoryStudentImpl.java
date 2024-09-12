package com.example.EduHub.service;

import com.example.EduHub.model.StudentModel;
import com.example.EduHub.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class InMemoryStudentImpl implements StudentService {
    private final StudentRepository studentRepository;

    public InMemoryStudentImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentModel> findAllStudent() {
        return studentRepository.findAllStudent();
    }

    @Override
    public StudentModel createStudent(StudentModel student) {
        return studentRepository.createStudent(student);
    }

    @Override
    public StudentModel updateStudent(StudentModel student) {
        return studentRepository.updateStudent(student);
    }

    @Override
    public StudentModel findStudentById(UUID id) {
        return studentRepository.findStudentById(id);
    }

    @Override
    public void deleteStudent(UUID id) {
        studentRepository.deleteStudent(id);
    }

    @Override
    public void createBulkStudents(int count) {
        for (int i = 0; i < count; i++) {
            String name = "Student " + (i + 1);
            String email = "student" + (i + 1) + "@example.com";
            String password = "password" + (i + 1);
            createStudent(new StudentModel(name, email, password));
        }
    }

    @Override
    public void deleteAllStudents() {
        studentRepository.deleteAllStudents();
    }
}