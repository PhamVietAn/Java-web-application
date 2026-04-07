package org.example.session03.repository;

import org.example.session03.model.Student;
import org.example.session03.model.StudentStatus;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepository {

    private final List<Student> students;

    public StudentRepository() {
        this.students = new ArrayList<>();

        students.add(new Student(1L, "Nguyen Long", "SV001", "CNTT", 2022, 3.72, StudentStatus.DANG_HOC));
        students.add(new Student(2L, "Tran Minh Anh", "SV002", "CNTT", 2021, 3.91, StudentStatus.DANG_HOC));
        students.add(new Student(3L, "Le Quoc Viet", "SV003", "KTPM", 2020, 3.35, StudentStatus.BAO_LUU));
        students.add(new Student(4L, "Pham Thu Ha", "SV004", "HTTT", 2019, 3.66, StudentStatus.TOT_NGHIEP));
        students.add(new Student(5L, "Do Gia Bao", "SV005", "CNTT", 2023, 3.48, StudentStatus.DANG_HOC));
        students.add(new Student(6L, "Vu Hoang Nam", "SV006", "KTPM", 2021, 3.83, StudentStatus.DANG_HOC));
    }

    public List<Student> findAll() {
        return new ArrayList<>(students);
    }

    public Optional<Student> findById(Long id) {
        return students.stream().filter(s -> s.getId().equals(id)).findFirst();
    }
}

