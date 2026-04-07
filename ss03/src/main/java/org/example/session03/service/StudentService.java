package org.example.session03.service;

import org.example.session03.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> getStudents(String search, String faculty, String sortBy);

    Optional<Student> getStudentById(Long id);

    DashboardStats getDashboardStats();
}

