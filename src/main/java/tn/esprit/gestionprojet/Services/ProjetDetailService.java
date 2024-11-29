package tn.esprit.gestionprojet.Services;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import tn.esprit.gestionprojet.Entities.Equipe;
import tn.esprit.gestionprojet.Entities.ProjetDetail;
import tn.esprit.gestionprojet.Repositories.ProjetDetailRepo;
import tn.esprit.gestionprojet.Services.IService.IProjetDetailService;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProjetDetailService implements IProjetDetailService {
    private final ProjetDetailRepo projetDetailRepo;

    @Override
    public List<ProjetDetail> findAllProjetDetail() {
        return projetDetailRepo.findAll();
    }

    @Override
    public ProjetDetail findProjetDetailById(Long id) {
        return projetDetailRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Project detail not found with id: " + id));
    }

    @Override
    public ProjetDetail saveProjetDetail(ProjetDetail projetDetail){
        return projetDetailRepo.save(projetDetail);
    }

    @Override
    public ProjetDetail updateProjetDetail(ProjetDetail projetDetail){
        Optional<ProjetDetail> existingUser = projetDetailRepo.findById(projetDetail.getId());
        if (existingUser.isPresent()) {
            return projetDetailRepo.save(projetDetail);
        } else {
            throw new EntityNotFoundException("Equipe not found with id: " + projetDetail.getId());
        }
    }

    @Override
    public void deleteProjetDetail(Long id){
        projetDetailRepo.deleteById(id);
    }
}
