package com.example.EduHub.service;

import com.example.EduHub.model.TeacherModel;
import java.util.List;
import java.util.UUID;

public interface TeacherService {
    List<TeacherModel> findAllTeachers();
    TeacherModel createTeacher(TeacherModel teacher);
    TeacherModel updateTeacher(TeacherModel teacher);
    TeacherModel findTeacherById(UUID id);
    void deleteTeacher(UUID id);
    void createBulkTeachers(int count);
    void deleteAllTeachers();
}