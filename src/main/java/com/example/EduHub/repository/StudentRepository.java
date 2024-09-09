package com.example.EduHub.repository;

import com.example.EduHub.model.StudentModel;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

@Repository
public class StudentRepository {
    private final List<StudentModel> STUDENTS = new ArrayList<>();

    public List<StudentModel> findAllStudent(){
        return STUDENTS;
    }

    public StudentModel findStudentById(UUID id){
        return STUDENTS.stream().filter(element -> element.getId().equals(id)).findFirst().orElse(null);
    }

    public StudentModel createStudent(StudentModel student){
        STUDENTS.add(student);
        return student;
    }

    public StudentModel updateStudent(StudentModel student){
        var studentIndex = IntStream.range(0, STUDENTS.size())
                .filter(index-> STUDENTS.get(index).getId().equals(student.getId()))
                .findFirst()
                .orElse(-1);
        if(studentIndex == -1){
            return null;
        }
        STUDENTS.set(studentIndex, student);
        return student;
    }

    public void deleteStudent(UUID id){
        var student = findStudentById(id);
        if(student != null){
            STUDENTS.remove(student);
        }
    }
}