package com.ecole.gestion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.ecole.gestion.respository.ProfesseurRepository;

@Controller
public class ProfesseurController {

    private final ProfesseurRepository repository;

    public ProfesseurController(ProfesseurRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/professeurs")
    public String professeurs(Model model) {
        model.addAttribute("professeurs", repository.findAll());
        return "professeurs";
    }
}