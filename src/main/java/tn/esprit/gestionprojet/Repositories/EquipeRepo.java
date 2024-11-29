package tn.esprit.gestionprojet.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.gestionprojet.Entities.Equipe;

@Repository
public interface EquipeRepo extends JpaRepository<Equipe, Integer> {

}
