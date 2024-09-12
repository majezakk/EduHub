package com.example.EduHub.service;

import com.example.EduHub.model.CourseModel;
import java.util.List;
import java.util.UUID;

public interface CourseService {
    List<CourseModel> findAllCourses();
    CourseModel createCourse(CourseModel course);
    CourseModel updateCourse(CourseModel course);
    CourseModel findCourseById(UUID id);
    void deleteCourse(UUID id);
    void createBulkCourses(int count);
    void deleteAllCourses();
}