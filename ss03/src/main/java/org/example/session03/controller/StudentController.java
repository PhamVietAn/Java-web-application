package org.example.session03.controller;

import org.example.session03.model.Student;
import org.example.session03.service.DashboardStats;
import org.example.session03.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/students";
    }

    @GetMapping("/students")
    public String listStudents(
            @RequestParam(required = false) String search,
            @RequestParam(required = false) String faculty,
            @RequestParam(required = false) String sortBy,
            Model model) {

        List<Student> students = studentService.getStudents(search, faculty, sortBy);

        model.addAttribute("students", students);
        model.addAttribute("search", search);
        model.addAttribute("faculty", faculty);
        model.addAttribute("sortBy", sortBy);
        model.addAttribute("resultCount", students.size());

        return "students/list";
    }

    @GetMapping("/students/detail")
    public String studentDetail(@RequestParam Long id, Model model) {
        Student student = studentService.getStudentById(id).orElse(null);
        if (student == null) {
            model.addAttribute("message", "Không tìm thấy sinh viên với id = " + id);
            return "students/detail";
        }

        model.addAttribute("student", student);
        return "students/detail";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        DashboardStats stats = studentService.getDashboardStats();
        model.addAttribute("stats", stats);
        return "dashboard/index";
    }
}

