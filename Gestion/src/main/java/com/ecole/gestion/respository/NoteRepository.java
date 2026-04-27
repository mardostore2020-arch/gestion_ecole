package com.ecole.gestion.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ecole.gestion.model.Note;
import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {

    List<Note> findByEtudiantId(Long id);

    public void save(com.ecole.gestion.controller.Note note);

}