package tn.esprit.gestionprojet.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.gestionprojet.Entities.Projet;

import java.util.List;

@Repository
public interface ProjetRepo extends JpaRepository<Projet,Long> {
}
