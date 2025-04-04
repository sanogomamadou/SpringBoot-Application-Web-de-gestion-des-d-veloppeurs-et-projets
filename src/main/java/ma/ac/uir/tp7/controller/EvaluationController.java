package ma.ac.uir.tp7.controller;

import ma.ac.uir.tp7.entity.Evaluation;
import ma.ac.uir.tp7.entity.Developer;
import ma.ac.uir.tp7.entity.Project;
import ma.ac.uir.tp7.service.EvaluationService;
import ma.ac.uir.tp7.service.DeveloperService;
import ma.ac.uir.tp7.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.ui.Model;

import java.util.List;


@Controller
public class EvaluationController {

    private final EvaluationService evaluationService;
    private final  DeveloperService developerService;
    private final ProjectService projectService;

    @Autowired
    public EvaluationController(EvaluationService evaluationService, DeveloperService developerService, ProjectService projectService) {
        this.evaluationService = evaluationService;
        this.developerService = developerService;
        this.projectService = projectService;
    }


    @PostMapping("/creationrate")
    public String rateDev(@ModelAttribute Evaluation evaluation, @RequestParam Long developerId, @RequestParam Long projectId,@RequestParam String feedback, @RequestParam String rating,Model model) {
        Developer developer = developerService.findById(developerId);
        Project project = projectService.findById(projectId);

        evaluation.setDeveloper(developer);
        evaluation.setProject(project);
        evaluation.setRating(Integer.parseInt(rating));
        evaluation.setFeedback(feedback);

        evaluationService.save(evaluation);
        model.addAttribute("message", "Notation réussie !");
        model.addAttribute("listDevelopers",developerService.getAllDevelopers());
        return "listedev";
    }


    @GetMapping("/Showrating")
    public String showEvaluation(Model model) {
        List<Developer> developers = developerService.getAllDevelopers();
        List<Project> projects = projectService.findAll();

        model.addAttribute("developers", developers);
        model.addAttribute("projects", projects);
        model.addAttribute("evaluation", new Evaluation());
        return "evaluerdev";
    }

    @GetMapping("/Showeval")
    public String Showeval(Model model, @RequestParam String id_dev) {
        model.addAttribute("listeval",evaluationService.findAll());
        model.addAttribute("id_dev",Integer.parseInt(id_dev));
        return "listeeval";
    }


}



