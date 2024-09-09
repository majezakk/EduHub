package com.example.EduHub.controller;

import com.example.EduHub.model.StudentModel;
import com.example.EduHub.service.InMemoryStudentImpl;
import com.example.EduHub.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(InMemoryStudentImpl studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String getStudentAll(Model model){
        var students = studentService.findAllStudent();
        model.addAttribute("students",students);
        return "index";
    }

    @GetMapping("/create")
    public String getCreateStudent(){
        return  "createStudent";
    }

    @PostMapping("/create")
    public String postCreateStudent(
            @RequestParam(name="name")
            String name,
            @RequestParam(name="email")
            String email,
            @RequestParam(name="password")
            String password
    ){
        studentService.createStudent(new StudentModel(name,email,password));
        return "redirect:/student";
    }
}
