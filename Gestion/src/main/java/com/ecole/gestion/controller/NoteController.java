package com.ecole.gestion.controller;

import com.ecole.gestion.model.Note;
import com.ecole.gestion.respository.EtudiantRepository;
import com.ecole.gestion.respository.MatiereRepository;
import com.ecole.gestion.respository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class NoteController {

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Autowired
    private MatiereRepository matiereRepository;

    @GetMapping("/notes")
    public String list(Model model) {
        model.addAttribute("notes", noteRepository.findAll());
        return "notes";
    }

    @GetMapping("/notes/new")
    public String form(Model model) {
        model.addAttribute("note", new Note());
        model.addAttribute("etudiants", etudiantRepository.findAll());
        model.addAttribute("matieres", matiereRepository.findAll());
        return "note-form";
    }

    @PostMapping("/notes")
    public String save(@ModelAttribute Note note) {
        noteRepository.save(note);
        return "redirect:/notes";
    }
}