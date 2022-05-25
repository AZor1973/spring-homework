package ru.azor.springhomework.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.azor.springhomework.entities.Student;
import ru.azor.springhomework.services.StudentService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private final StudentService service;

    @GetMapping
    public String getAllStudents(Model model) {
        List<Student> students = service.getAllStudents();
        model.addAttribute("students", students);
        return "student-list";
    }

    @GetMapping("/create")
    public String showForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "create-student";
    }

    @GetMapping("/update")
    public String showUpdateForm(Model model, @RequestParam Long id) {
        Student student = service.getStudentById(id);
        model.addAttribute("student", student);
        return "create-student";
    }

    @PostMapping("/create")
    public String processForm(@ModelAttribute Student student) {
        service.saveNewStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/delete/{id}")
    public String expelStudent(@PathVariable Long id) {
        service.expelStudentById(id);
        return "redirect:/students";
    }
}
