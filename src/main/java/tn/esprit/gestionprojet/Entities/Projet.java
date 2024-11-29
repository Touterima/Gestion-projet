package tn.esprit.gestionprojet.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Projet implements Serializable {
    @Id
    private String id;
    private String sujet;

    @OneToOne(mappedBy = "projet")
    private ProjetDetail projetDetails;

    @ManyToMany
    private Set<Equipe>equipes;


}
