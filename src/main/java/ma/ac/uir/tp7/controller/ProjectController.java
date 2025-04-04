package ma.ac.uir.tp7.controller;

import ma.ac.uir.tp7.entity.Developer;
import ma.ac.uir.tp7.entity.Project;
import ma.ac.uir.tp7.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.ui.Model;

import java.util.Objects;
import java.util.Optional;

@Controller
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    // Liste tous les projets
    @GetMapping("/AfficherProjet")
    public String viewProjetpage(Model model) {
        model.addAttribute("listprojects",projectService.findAll());
        return "listeproj";
    }
    @GetMapping("/listePro")
    public String listePro(Model model) {
        model.addAttribute("listprojects",projectService.findAll());
        return "listeprodev";
    }





    @PostMapping("/creationprojet")
    public String processCreerprojet(@RequestParam String title, @RequestParam String description, @RequestParam String estimatedDuration, Model model)
    { Project project = new Project();
        project.setTitle(title);
        project.setDescription(description);
        project.setStatut("EN COURS");
        project.setEstimatedDuration(Integer.parseInt(estimatedDuration));
        projectService.save(project);
        model.addAttribute("listprojects",projectService.findAll());
        return "listeproj"; }

    @GetMapping("/Showcreation")
    public String showCreateForm(Model model)
    { return "créerprojet"; }

    @GetMapping("/deleteProject/{id}")
    public String deleteProject(@PathVariable (value = "id") long id)
    {
        this.projectService.deleteById(id);
        return "redirect:/AfficherProjet";
    }



}
