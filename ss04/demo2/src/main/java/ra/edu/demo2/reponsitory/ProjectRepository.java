package ra.edu.demo2.reponsitory;

import ra.edu.demo2.model.entity.Project;

import java.util.List;

public interface ProjectRepository {
    List<Project> findAll();
    Project findById(int prjId);
}
