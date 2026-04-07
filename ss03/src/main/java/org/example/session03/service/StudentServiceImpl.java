package org.example.session03.service;

import org.example.session03.model.Student;
import org.example.session03.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getStudents(String search, String faculty, String sortBy) {
        List<Student> filtered = studentRepository.findAll().stream()
                .filter(student -> matchesSearch(student, search))
                .filter(student -> matchesFaculty(student, faculty))
                .collect(Collectors.toList());

        if ("name".equalsIgnoreCase(sortBy)) {
            filtered.sort(Comparator.comparing(Student::getFullName, String.CASE_INSENSITIVE_ORDER));
        } else if ("gpa".equalsIgnoreCase(sortBy)) {
            filtered.sort(Comparator.comparingDouble(Student::getGpa).reversed());
        }

        return filtered;
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public DashboardStats getDashboardStats() {
        List<Student> allStudents = studentRepository.findAll();
        int totalStudents = allStudents.size();

        Map<String, Double> statusPercentages = new LinkedHashMap<>();
        if (totalStudents > 0) {
            Map<String, Long> statusCounts = allStudents.stream()
                    .collect(Collectors.groupingBy(
                            student -> student.getStatus().getDisplayName(),
                            LinkedHashMap::new,
                            Collectors.counting()));

            statusCounts.forEach((status, count) -> {
                double percentage = (count * 100.0) / totalStudents;
                statusPercentages.put(status, percentage);
            });
        }

        double averageGpa = allStudents.stream()
                .mapToDouble(Student::getGpa)
                .average()
                .orElse(0.0);

        Student topStudent = allStudents.stream()
                .max(Comparator.comparingDouble(Student::getGpa))
                .orElse(null);

        return new DashboardStats(totalStudents, statusPercentages, averageGpa, topStudent);
    }

    private boolean matchesSearch(Student student, String search) {
        if (search == null || search.isBlank()) {
            return true;
        }

        String keyword = search.toLowerCase(Locale.ROOT);
        return student.getFullName().toLowerCase(Locale.ROOT).contains(keyword)
                || student.getStudentCode().toLowerCase(Locale.ROOT).contains(keyword);
    }

    private boolean matchesFaculty(Student student, String faculty) {
        if (faculty == null || faculty.isBlank()) {
            return true;
        }

        return student.getFaculty().equalsIgnoreCase(faculty.trim());
    }
}

