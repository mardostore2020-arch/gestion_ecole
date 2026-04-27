package com.ecole.gestion.service;

import com.ecole.gestion.model.Bulletin;
import com.ecole.gestion.model.Etudiant;
import com.ecole.gestion.respository.BulletinRepository;
import com.ecole.gestion.respository.EtudiantRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BulletinService {

    private final BulletinRepository bulletinRepository;
    private final EtudiantRepository etudiantRepository;

    public BulletinService(BulletinRepository bulletinRepository, EtudiantRepository etudiantRepository) {
        this.bulletinRepository = bulletinRepository;
        this.etudiantRepository = etudiantRepository;
    }

    public Bulletin creerBulletin(Long etudiantId, String annee) {
        Optional<Etudiant> etudiantOpt = etudiantRepository.findById(etudiantId);
        if (etudiantOpt.isEmpty()) {
            throw new RuntimeException("Etudiant non trouvé avec l'id " + etudiantId);
        }

        Bulletin bulletin = new Bulletin();
        bulletin.setEtudiant(etudiantOpt.get());
        bulletin.setAnnee(annee);

        return bulletinRepository.save(bulletin);
    }

    public List<Bulletin> listerBulletins() {
        return bulletinRepository.findAll();
    }

    public double calculerMoyenne(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}