package com.example.EduHub.service;

import com.example.EduHub.model.TeacherModel;
import com.example.EduHub.repository.TeacherRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class InMemoryTeacherImpl implements TeacherService {
    private final TeacherRepository teacherRepository;

    public InMemoryTeacherImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<TeacherModel> findAllTeachers() {
        return teacherRepository.findAllTeachers();
    }

    @Override
    public TeacherModel createTeacher(TeacherModel teacher) {
        return teacherRepository.createTeacher(teacher);
    }

    @Override
    public TeacherModel updateTeacher(TeacherModel teacher) {
        return teacherRepository.updateTeacher(teacher);
    }

    @Override
    public TeacherModel findTeacherById(UUID id) {
        return teacherRepository.findTeacherById(id);
    }

    @Override
    public void deleteTeacher(UUID id) {
        teacherRepository.deleteTeacher(id);
    }

    @Override
    public void createBulkTeachers(int count) {
        for (int i = 0; i < count; i++) {
            String name = "Teacher " + (i + 1);
            String email = "teacher" + (i + 1) + "@example.com";
            String department = "Department " + ((i % 5) + 1); // 5 разных отделов
            createTeacher(new TeacherModel(name, email, department));
        }
    }

    @Override
    public void deleteAllTeachers() {
        teacherRepository.deleteAllTeachers();
    }
}