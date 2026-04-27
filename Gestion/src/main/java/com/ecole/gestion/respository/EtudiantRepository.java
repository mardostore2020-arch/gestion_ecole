package com.ecole.gestion.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ecole.gestion.model.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
}