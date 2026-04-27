package com.ecole.gestion.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ecole.gestion.model.Professeur;

public interface ProfesseurRepository extends JpaRepository<Professeur, Long> {
}