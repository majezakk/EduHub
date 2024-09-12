package com.example.EduHub.controller;

import com.example.EduHub.model.StudentModel;
import com.example.EduHub.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;
    private static final int PAGE_SIZE = 10;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String getStudentAll(@RequestParam(defaultValue = "0") int page, Model model) {
        List<StudentModel> students = studentService.findAllStudent();
        int totalPages = (int) Math.ceil((double) students.size() / PAGE_SIZE);

        int start = page * PAGE_SIZE;
        int end = Math.min(start + PAGE_SIZE, students.size());
        List<StudentModel> pageStudents = students.subList(start, end);

        model.addAttribute("students", pageStudents);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        return "index";
    }

    @GetMapping("/create")
    public String getCreateStudent() {
        return "createStudent";
    }

    @PostMapping("/create")
    public String postCreateStudent(
            @RequestParam(name="name") String name,
            @RequestParam(name="email") String email,
            @RequestParam(name="password") String password
    ) {
        studentService.createStudent(new StudentModel(name, email, password));
        return "redirect:/student";
    }

    @PostMapping("/delete/{id}")
    public String deleteStudent(@PathVariable UUID id) {
        studentService.deleteStudent(id);
        return "redirect:/student";
    }

    @PostMapping("/create-bulk")
    public String createBulkStudents() {
        studentService.createBulkStudents(20);
        return "redirect:/student";
    }

    @PostMapping("/delete-all")
    public String deleteAllStudents() {
        studentService.deleteAllStudents();
        return "redirect:/student";
    }
}