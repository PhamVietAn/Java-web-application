package ra.edu.demo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ra.edu.demo2.model.entity.Project;
import ra.edu.demo2.service.ProjectService;

@Controller
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping({"/", "/projects"})
    public String home(Model model) {
        model.addAttribute("projectList", projectService.getProjects());
        return "project-list";
    }

    @GetMapping("/projects/{prjId}")
    public String showProject(@PathVariable("prjId") int prjId, Model model) {
        Project project = projectService.getProjectById(prjId);
        model.addAttribute("project", project);
        if (project == null) {
            model.addAttribute("errorMessage", "Không tìm thấy dự án có mã " + prjId + ".");
        }
        return "project-detail";
    }
}
