package tn.esprit.gestionprojet.Services.IService;

import tn.esprit.gestionprojet.Entities.Projet;

import java.util.List;

public interface IProjetService {
    List<Projet> findAllProjets();
    Projet findProjetById(Long id);
    Projet addProjet(Projet projet);
    Projet updateProjet(Projet projet);
    void deleteProjet(Long id);
}
