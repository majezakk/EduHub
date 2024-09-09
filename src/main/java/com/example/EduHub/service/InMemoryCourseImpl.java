package com.example.EduHub.service;

import com.example.EduHub.model.CourseModel;
import com.example.EduHub.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InMemoryCourseImpl implements CourseService {
    private final CourseRepository courseRepository;

    public InMemoryCourseImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<CourseModel> findAllCourses() {
        return courseRepository.findAllCourses();
    }

    @Override
    public CourseModel createCourse(CourseModel course) {
        return courseRepository.createCourse(course);
    }

    @Override
    public CourseModel updateCourse(CourseModel course) {
        return courseRepository.updateCourse(course);
    }

    @Override
    public CourseModel findCourseById(UUID id) {
        return courseRepository.findCourseById(id);
    }

    @Override
    public void deleteCourse(UUID id) {
        courseRepository.deleteCourse(id);
    }
}