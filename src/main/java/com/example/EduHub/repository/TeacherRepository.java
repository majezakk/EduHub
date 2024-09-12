package com.example.EduHub.repository;

import com.example.EduHub.model.TeacherModel;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

@Repository
public class TeacherRepository {
    private final List<TeacherModel> TEACHERS = new ArrayList<>();

    public List<TeacherModel> findAllTeachers() {
        return TEACHERS;
    }

    public TeacherModel findTeacherById(UUID id) {
        return TEACHERS.stream().filter(element -> element.getId().equals(id)).findFirst().orElse(null);
    }

    public TeacherModel createTeacher(TeacherModel teacher) {
        TEACHERS.add(teacher);
        return teacher;
    }

    public TeacherModel updateTeacher(TeacherModel teacher) {
        var teacherIndex = IntStream.range(0, TEACHERS.size())
                .filter(index -> TEACHERS.get(index).getId().equals(teacher.getId()))
                .findFirst()
                .orElse(-1);
        if (teacherIndex == -1) {
            return null;
        }
        TEACHERS.set(teacherIndex, teacher);
        return teacher;
    }

    public void deleteTeacher(UUID id) {
        var teacher = findTeacherById(id);
        if (teacher != null) {
            TEACHERS.remove(teacher);
        }
    }

    public void deleteAllTeachers() {
        TEACHERS.clear();
    }
}