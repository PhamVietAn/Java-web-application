package ra.edu.ss02_ex05.service;

import org.springframework.stereotype.Service;
import ra.edu.ss02_ex05.exception.EmployeeNotFoundException;
import ra.edu.ss02_ex05.model.Employee;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            employees.add(new Employee("NV001", "Nguyễn Thị Lan", "Kế toán", 15000000, sdf.parse("2020-03-01"), "Đang làm"));
            employees.add(new Employee("NV002", "Trần Văn Hùng", "Kỹ thuật", 25000000, sdf.parse("2019-07-15"), "Đang làm"));
            employees.add(new Employee("NV003", "Lê Minh Đức", "Kinh doanh", 18500000, sdf.parse("2021-11-20"), "Nghỉ phép"));
            employees.add(new Employee("NV004", "Phạm Thu Hương", "Kỹ thuật", 22000000, sdf.parse("2022-01-05"), "Đang làm"));
            employees.add(new Employee("NV005", "Hoàng Văn Nam", "Kế toán", 12000000, sdf.parse("2023-06-10"), "Thử việc"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return employees;
    }

    public Employee getByCode(String code) {
        return getAllEmployees().stream()
                .filter(emp -> emp.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(() ->
                        new EmployeeNotFoundException("Nhân viên [" + code + "] không tồn tại trong hệ thống"));
    }

    public double getTechnicalDepartmentTotalSalary() {
        return getAllEmployees().stream()
                .filter(emp -> "Kỹ thuật".equals(emp.getDepartment()))
                .mapToDouble(Employee::getSalary)
                .sum();
    }
}