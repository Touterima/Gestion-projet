package tn.esprit.gestionprojet.Services.IService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.gestionprojet.Entities.Equipe;

import java.util.List;


public interface IEquipeService {
    List<Equipe> findAllEquipes();
    Equipe findEquipeById(int id);
    Equipe addEquipe(Equipe equipe);
    Equipe updateEquipe(Equipe equipe);
    void deleteEquipe(int id);
}
