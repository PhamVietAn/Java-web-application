package ra.edu.demo2.service.impl;

import org.springframework.stereotype.Service;
import ra.edu.demo2.model.entity.Project;
import ra.edu.demo2.reponsitory.ProjectRepository;
import ra.edu.demo2.service.ProjectService;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project getProjectById(int id) {
        return projectRepository.findById(id);
    }
}
