package ma.ac.uir.tp7.controller;

import ma.ac.uir.tp7.entity.Assignment;
import ma.ac.uir.tp7.entity.Developer;
import ma.ac.uir.tp7.entity.Project;
import ma.ac.uir.tp7.service.AssignmentService;
import ma.ac.uir.tp7.service.DeveloperService;
import ma.ac.uir.tp7.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.ui.Model;

import java.util.List;


@Controller
public class AssignmentController {

    private final AssignmentService assignmentService;
    private final  DeveloperService developerService;
    private final ProjectService projectService;

    @Autowired
    public AssignmentController(AssignmentService assignmentService, DeveloperService developerService, ProjectService projectService) {
        this.assignmentService = assignmentService;
        this.developerService = developerService;
        this.projectService = projectService;
    }




    // Liste tous les utilisateurs
    @GetMapping("/Showassignment")
    public String showAssignmentPage(Model model) {
        model.addAttribute("listassignments",assignmentService.findAll());
        return "listeassign";
    }
    @GetMapping("/Showassignmentaffec")
    public String Showassignmentaffec(Model model, @RequestParam String id_dev) {
        model.addAttribute("listassignment",assignmentService.findAll());
        model.addAttribute("id_dev",Integer.parseInt(id_dev));
        return "listeassigndev";
    }


    @PostMapping("/creationass")
    public String assignProject(@ModelAttribute Assignment assignment, @RequestParam Long developerId, @RequestParam Long projectId,Model model) {
        Developer developer = developerService.findById(developerId);
        Project project = projectService.findById(projectId);
        assignment.setDeveloper(developer);
        assignment.setProject(project);
        assignmentService.save(assignment);
        model.addAttribute("listassignments",assignmentService.findAll());
        return "listeassign";
    }


    @GetMapping("/Assigncreation")
    public String showAssignmentForm(Model model) {
        List<Developer> developers = developerService.getAllDevelopers();
        List<Project> projects = projectService.findAll();

        model.addAttribute("developers", developers);
        model.addAttribute("projects", projects);
        model.addAttribute("assignment", new Assignment());
        return "assignerprojet";
    }

    @GetMapping("/assigneProject/{id}")
    public String assignProject(@PathVariable (value = "id") long id)
    {
        this.assignmentService.deleteById(id);
        return "redirect:/Showassignment";
    }


}
