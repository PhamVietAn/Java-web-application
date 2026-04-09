package ra.edu.demo2.service;

import ra.edu.demo2.model.entity.Project;

import java.util.List;

public interface ProjectService {
    List<Project> getProjects();
    Project getProjectById(int id);
}
