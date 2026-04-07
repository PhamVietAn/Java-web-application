package org.example.session03.model;

public class Student {
    private Long id;
    private String fullName;
    private String studentCode;
    private String faculty;
    private int enrollmentYear;
    private double gpa;
    private StudentStatus status;

    public Student(Long id, String fullName, String studentCode, String faculty, int enrollmentYear, double gpa, StudentStatus status) {
        this.id = id;
        this.fullName = fullName;
        this.studentCode = studentCode;
        this.faculty = faculty;
        this.enrollmentYear = enrollmentYear;
        this.gpa = gpa;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public String getFaculty() {
        return faculty;
    }

    public int getEnrollmentYear() {
        return enrollmentYear;
    }

    public double getGpa() {
        return gpa;
    }

    public StudentStatus getStatus() {
        return status;
    }
}

