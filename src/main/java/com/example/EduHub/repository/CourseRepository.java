package com.example.EduHub.repository;

import com.example.EduHub.model.CourseModel;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

@Repository
public class CourseRepository {
    private final List<CourseModel> COURSES = new ArrayList<>();

    public List<CourseModel> findAllCourses() {
        return COURSES;
    }

    public CourseModel findCourseById(UUID id) {
        return COURSES.stream().filter(element -> element.getId().equals(id)).findFirst().orElse(null);
    }

    public CourseModel createCourse(CourseModel course) {
        COURSES.add(course);
        return course;
    }

    public CourseModel updateCourse(CourseModel course) {
        var courseIndex = IntStream.range(0, COURSES.size())
                .filter(index -> COURSES.get(index).getId().equals(course.getId()))
                .findFirst()
                .orElse(-1);
        if (courseIndex == -1) {
            return null;
        }
        COURSES.set(courseIndex, course);
        return course;
    }

    public void deleteCourse(UUID id) {
        var course = findCourseById(id);
        if (course != null) {
            COURSES.remove(course);
        }
    }

    public void deleteAllCourses() {
        COURSES.clear();
    }
}