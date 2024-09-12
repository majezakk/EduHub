package com.example.EduHub.service;

import com.example.EduHub.model.CourseModel;
import com.example.EduHub.repository.CourseRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.Random;

@Service
public class InMemoryCourseImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final Random random = new Random();

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

    @Override
    public void createBulkCourses(int count) {
        String[] subjects = {"Math", "Physics", "Chemistry", "Biology", "History", "Literature", "Computer Science"};
        String[] levels = {"Introductory", "Intermediate", "Advanced"};

        for (int i = 0; i < count; i++) {
            String name = levels[random.nextInt(levels.length)] + " " + subjects[random.nextInt(subjects.length)];
            String description = "This is a course about " + name;
            int hours = (random.nextInt(5) + 1) * 16; // 16 to 80 hours (1 to 5 credits * 16 hours per credit)
            createCourse(new CourseModel(name, description, hours));
        }
    }

    @Override
    public void deleteAllCourses() {
        courseRepository.deleteAllCourses();
    }
}