package ra.edu.ss02_ex05.model;

import java.util.Date;

public class Employee {
    private String code;
    private String fullName;
    private String department;
    private double salary;
    private Date joinDate;
    private String status;

    public Employee() {
    }

    public Employee(String code, String fullName, String department, double salary, Date joinDate, String status) {
        this.code = code;
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
        this.joinDate = joinDate;
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public String getStatus() {
        return status;
    }
}