package tn.esprit.gestionprojet.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.gestionprojet.Entities.ProjetDetail;

@Repository
public interface ProjetDetailRepo extends JpaRepository<ProjetDetail, Long> {
}
