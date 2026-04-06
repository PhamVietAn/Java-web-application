package ra.edu.ss02_ex05.controller;


import ra.edu.ss02_ex05.model.Employee;
import ra.edu.ss02_ex05.service.EmployeeService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public String showEmployees(HttpSession session, Model model) {
        if (session.getAttribute("loggedUser") == null) {
            return "redirect:/login";
        }

        List<Employee> employees = employeeService.getAllEmployees();
        double technicalTotalSalary = employeeService.getTechnicalDepartmentTotalSalary();

        model.addAttribute("employees", employees);
        model.addAttribute("technicalTotalSalary", technicalTotalSalary);

        return "employees";
    }

    @GetMapping("/employees/{code}")
    public String showEmployeeDetail(@PathVariable String code,
                                     HttpSession session,
                                     Model model) {
        if (session.getAttribute("loggedUser") == null) {
            return "redirect:/login";
        }

        Employee employee = employeeService.getByCode(code);
        model.addAttribute("employee", employee);

        return "employee-detail";
    }
}