package com.ecole.gestion.controller;

import com.ecole.gestion.model.Etudiant;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;



public class Note {

   
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double valeur;


    private Etudiant etudiant;

  
    private Matiere matiere;

    public Long getId() {
        return id;
    }

    public double getValeur() {
        return valeur;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }
}