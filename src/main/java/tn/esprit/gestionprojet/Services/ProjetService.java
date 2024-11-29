package tn.esprit.gestionprojet.Services;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.gestionprojet.Entities.Projet;
import tn.esprit.gestionprojet.Entities.ProjetDetail;
import tn.esprit.gestionprojet.Repositories.ProjetRepo;
import tn.esprit.gestionprojet.Services.IService.IProjetService;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProjetService implements IProjetService {
    private final ProjetRepo projetRepo;

    @Override
    public List<Projet> findAllProjets(){
        return projetRepo.findAll();
    }

    @Override
    public Projet findProjetById(Long id){
        return projetRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Project not found with id: " + id));
    }

    @Override
    public Projet addProjet(Projet projet){
        return projetRepo.save(projet);
    }

    @Override
    public Projet updateProjet(Projet projet){
        Optional<Projet> existingUser = projetRepo.findById(Long.valueOf(projet.getId()));
        if (existingUser.isPresent()) {
            return projetRepo.save(projet);
        } else {
            throw new EntityNotFoundException("Project not found with id: " + projet.getId());
        }
    }

    @Override
    public void deleteProjet(Long id){
        projetRepo.deleteById(id);
    }
}
