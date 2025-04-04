package ma.ac.uir.tp7.controller;

import ma.ac.uir.tp7.entity.Developer;
import ma.ac.uir.tp7.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.ui.Model;

import java.util.Objects;
import java.util.Optional;

@Controller
public class DeveloperController {
    @Autowired
    private DeveloperService developerService;

    // Liste tous les utilisateurs
    @GetMapping("/index")
    public String viewHomePage(Model model) {
        model.addAttribute("listDevelopers",developerService.getAllDevelopers());
        return "index";
    }



    @GetMapping("/sign-up")
    public String showSignUpForm(Model model)
    { return "sign-up"; }

    @PostMapping("/sign-up")
    public String processSignUp(@RequestParam String name, @RequestParam String login, @RequestParam String password, Model model)
    { Developer developer = new Developer();


        String role="DEVELOPPEUR";
        developer.setName(name);
        developer.setLogin(login);
        developer.setPassword(password);
        developer.setRole(Developer.Role.DEVELOPPEUR);
        developerService.save(developer);
        model.addAttribute("message", "Inscription réussie !");
        return "sign-in"; }

    @PostMapping("/listedev")
    public String showListedev(Model model) {
        model.addAttribute("listDevelopers",developerService.getAllDevelopers());
        return "listedev"; //
    }
    @PostMapping("/deconnexion")
    public String deconnexion() {
        return "sign-in"; //
    }




    @GetMapping("/sign-in")
    public String showSignInForm(Model model)
    { return "sign-in"; }

    @GetMapping("/showsign-in")
    public String showsign(Model model)
    { return "sign-in";}


        @PostMapping("/sign-in")
    public String processSignIn(@RequestParam String login, @RequestParam String password, Model model)
    { Optional<Developer> User = developerService.getDeveloperByLogin(login);
        if (User.isPresent())
        { Developer developer = User.get();
            if (Objects.equals(password, developer.getPassword()) && developer.getRole() == Developer.Role.CHEF_PROJET)
            { model.addAttribute("listDevelopers",developerService.getAllDevelopers());
                return "index";
            }
            else if ((Objects.equals(password, developer.getPassword()) && developer.getRole() == Developer.Role.DEVELOPPEUR))
            {
                model.addAttribute("dev",developerService.findByLogin(developer.getLogin()));
                return "indexdev";
            }
        }

        model.addAttribute("error", "Login ou mot de passe incorrect");
        return "sign-in"; }


    @GetMapping("/deleteDev/{id}")
    public String deleteDev(@PathVariable (value = "id") long id, Model model)
    {
        this.developerService.deleteById(id);
        model.addAttribute("listDevelopers",developerService.getAllDevelopers());
        return "listedev";
    }



}
