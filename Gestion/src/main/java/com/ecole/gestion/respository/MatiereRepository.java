package com.ecole.gestion.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ecole.gestion.model.Matiere;

public interface MatiereRepository extends JpaRepository<Matiere, Long> {

    public void save(com.ecole.gestion.controller.Matiere matiere);
}
