package com.ecole.gestion.controller;

import com.ecole.gestion.model.Etudiant;
import com.ecole.gestion.respository.EtudiantRepository;
import com.ecole.gestion.service.BulletinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EtudiantController {

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Autowired
    private BulletinService bulletinService;

    @GetMapping("/etudiants")
    public String listEtudiants(Model model) {
        model.addAttribute("etudiants", etudiantRepository.findAll());
        return "etudiants";
    }

    @GetMapping("/etudiants/new")
    public String createForm(Model model) {
        model.addAttribute("etudiant", new Etudiant());
        return "etudiant-form";
    }

    @PostMapping("/etudiants")
    public String saveEtudiant(@ModelAttribute Etudiant etudiant) {
        etudiantRepository.save(etudiant);
        return "redirect:/etudiants";
    }

    @GetMapping("/bulletin/{id}")
    public String bulletin(@PathVariable Long id, Model model) {
        double moyenne = bulletinService.calculerMoyenne(id);
        model.addAttribute("moyenne", moyenne);
        return "bulletin";
    }
}
