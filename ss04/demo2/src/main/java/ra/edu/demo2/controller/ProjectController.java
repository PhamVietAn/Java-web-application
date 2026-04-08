package ra.edu.demo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ra.edu.demo2.reponsitory.ProjectRepository;
import ra.edu.demo2.service.ProjectService;

@Controller
@RequestMapping(value = {"/projectList","/"})
public class ProjectController {
    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public String home(Model model){
        model.addAttribute("projectList", projectService.getProjects());
        return "project-list";
    }

    @GetMapping("/{prjId}")
    public String showProject(@PathVariable("prjId") String prjId, Model model){
        model.addAttribute("project", projectService.getProjectById(Integer.parseInt(prjId)));
        return "project-detail";
    }

    @GetMapping("/{prjName}")
    public String showProjectDetail(@PathVariable("prjName") String prjName, Model model){
        model.addAttribute("project", projectService.getProjectById(Integer.parseInt(prjName)));
        return "project-detail";
    }

}
