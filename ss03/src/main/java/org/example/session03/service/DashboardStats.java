package org.example.session03.service;

import org.example.session03.model.Student;

import java.util.Map;

public class DashboardStats {
    private final int totalStudents;
    private final Map<String, Double> statusPercentages;
    private final double averageGpa;
    private final Student topStudent;

    public DashboardStats(int totalStudents, Map<String, Double> statusPercentages, double averageGpa, Student topStudent) {
        this.totalStudents = totalStudents;
        this.statusPercentages = statusPercentages;
        this.averageGpa = averageGpa;
        this.topStudent = topStudent;
    }

    public int getTotalStudents() {
        return totalStudents;
    }

    public Map<String, Double> getStatusPercentages() {
        return statusPercentages;
    }

    public double getAverageGpa() {
        return averageGpa;
    }

    public Student getTopStudent() {
        return topStudent;
    }
}

