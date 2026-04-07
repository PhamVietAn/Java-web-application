package ra.edu.bkt.contronller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.edu.bkt.model.Employee;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = {"/employee-list","/"})
public class EmployeeController {
    @GetMapping
    public String getEmployeeList(Model model) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Nguyễn Văn A", "Phòng Đào tạo", 8500000.0));
        employees.add(new Employee(2, "Trần Thị B", "Phòng Đào tạo", 12000000.0));
        employees.add(new Employee(3, "Lê Văn C", "Phòng Đào tạo", 9500000.0));
        employees.add(new Employee(4, "Phạm Thị D", "Phòng Đào tạo", 15000000.0));

        model.addAttribute("employeeList", employees);

        return "employee-list";
    }
}
