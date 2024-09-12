package com.example.EduHub.controller;

import com.example.EduHub.model.TeacherModel;
import com.example.EduHub.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    private final TeacherService teacherService;
    private static final int PAGE_SIZE = 10;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public String getAllTeachers(@RequestParam(defaultValue = "0") int page, Model model) {
        List<TeacherModel> teachers = teacherService.findAllTeachers();
        int totalPages = (int) Math.ceil((double) teachers.size() / PAGE_SIZE);

        int start = page * PAGE_SIZE;
        int end = Math.min(start + PAGE_SIZE, teachers.size());
        List<TeacherModel> pageTeachers = teachers.subList(start, end);

        model.addAttribute("teachers", pageTeachers);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        return "teacherIndex";
    }

    @GetMapping("/create")
    public String getCreateTeacher() {
        return "createTeacher";
    }

    @PostMapping("/create")
    public String postCreateTeacher(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "email") String email,
            @RequestParam(name = "department") String department
    ) {
        teacherService.createTeacher(new TeacherModel(name, email, department));
        return "redirect:/teacher";
    }

    @PostMapping("/delete/{id}")
    public String deleteTeacher(@PathVariable UUID id) {
        teacherService.deleteTeacher(id);
        return "redirect:/teacher";
    }

    @PostMapping("/create-bulk")
    public String createBulkTeachers() {
        teacherService.createBulkTeachers(20);
        return "redirect:/teacher";
    }

    @PostMapping("/delete-all")
    public String deleteAllTeachers() {
        teacherService.deleteAllTeachers();
        return "redirect:/teacher";
    }
}