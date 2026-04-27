package com.ecole.gestion.controller;

import com.ecole.gestion.model.Matiere;
import com.ecole.gestion.respository.MatiereRepository;
import com.ecole.gestion.respository.ProfesseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MatiereController {

    @Autowired
    private MatiereRepository matiereRepository;

    @Autowired
    private ProfesseurRepository professeurRepository;

    @GetMapping("/matieres")
    public String list(Model model) {
        model.addAttribute("matieres", matiereRepository.findAll());
        return "matieres";
    }

    @GetMapping("/matieres/new")
    public String form(Model model) {
        model.addAttribute("matiere", new Matiere());
        model.addAttribute("professeurs", professeurRepository.findAll());
        return "matiere-form";
    }

    @PostMapping("/matieres")
    public String save(@ModelAttribute Matiere matiere) {
        matiereRepository.save(matiere);
        return "redirect:/matieres";
    }
}