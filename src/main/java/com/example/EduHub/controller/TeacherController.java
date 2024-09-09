package com.example.EduHub.controller;

import com.example.EduHub.model.TeacherModel;
import com.example.EduHub.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public String getAllTeachers(Model model) {
        var teachers = teacherService.findAllTeachers();
        model.addAttribute("teachers", teachers);
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
}
