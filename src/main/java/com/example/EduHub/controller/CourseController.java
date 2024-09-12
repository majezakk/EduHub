package com.example.EduHub.controller;

import com.example.EduHub.model.CourseModel;
import com.example.EduHub.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/course")
public class CourseController {
    private final CourseService courseService;
    private static final int PAGE_SIZE = 10;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public String getAllCourses(@RequestParam(defaultValue = "0") int page, Model model) {
        List<CourseModel> courses = courseService.findAllCourses();
        int totalPages = (int) Math.ceil((double) courses.size() / PAGE_SIZE);

        int start = page * PAGE_SIZE;
        int end = Math.min(start + PAGE_SIZE, courses.size());
        List<CourseModel> pageCourses = courses.subList(start, end);

        model.addAttribute("courses", pageCourses);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
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
            @RequestParam(name = "hours") int hours
    ) {
        courseService.createCourse(new CourseModel(name, description, hours));
        return "redirect:/course";
    }

    @PostMapping("/delete/{id}")
    public String deleteCourse(@PathVariable UUID id) {
        courseService.deleteCourse(id);
        return "redirect:/course";
    }

    @PostMapping("/create-bulk")
    public String createBulkCourses() {
        courseService.createBulkCourses(20);
        return "redirect:/course";
    }

    @PostMapping("/delete-all")
    public String deleteAllCourses() {
        courseService.deleteAllCourses();
        return "redirect:/course";
    }
}