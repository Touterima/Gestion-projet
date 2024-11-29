package tn.esprit.gestionprojet.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.*;
import tn.esprit.gestionprojet.Entities.Enums.Domaine;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Equipe implements Serializable {
    @Id
    private int id;
    private String nom;
    private Domaine domaine;

    @ManyToMany
    private Set<Projet> projets;
}
