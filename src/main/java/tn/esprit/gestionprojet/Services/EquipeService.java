package tn.esprit.gestionprojet.Services;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.gestionprojet.Entities.Equipe;
import tn.esprit.gestionprojet.Repositories.EquipeRepo;
import tn.esprit.gestionprojet.Services.IService.IEquipeService;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class EquipeService implements IEquipeService {
    private final EquipeRepo equipeRepo;

    @Override
    public List<Equipe> findAllEquipes() {
        return equipeRepo.findAll();
    }

    @Override
    public Equipe findEquipeById(int id) {
        return equipeRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Equipe not found with id: " + id));
    }

    @Override
    public Equipe addEquipe(Equipe equipe){
        return equipeRepo.save(equipe);
    }

    @Override
    public Equipe updateEquipe(Equipe equipe){
        Optional<Equipe> existingUser = equipeRepo.findById(equipe.getId());
        if (existingUser.isPresent()) {
            return equipeRepo.save(equipe);
        } else {
            throw new EntityNotFoundException("Equipe not found with id: " + equipe.getId());
        }
    }

    @Override
    public void deleteEquipe(int id) {
        equipeRepo.deleteById(id);
    }






}
