package com.example.EduHub.controller;

import com.example.EduHub.model.CourseModel;
import com.example.EduHub.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.UUID;


@Controller
@RequestMapping("/course")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public String getAllCourses(Model model) {
        var courses = courseService.findAllCourses();
        model.addAttribute("courses", courses);
        return "courseIndex";
    }

    @GetMapping("/create")
    public String getCreateCourse() {
        return "createCourse";
    }

    @PostMapping("/create")
    public String postCreateCourse(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "description") String description,
            @RequestParam(name = "credits") int credits
    ) {
        courseService.createCourse(new CourseModel(name, description, credits));
        return "redirect:/course";
    }

    @PostMapping("/delete/{id}")
    public String deleteCourse(@PathVariable UUID id) {
        courseService.deleteCourse(id);
        return "redirect:/course";
    }
}
