package tn.esprit.gestionprojet.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjetDetail {
    @Id
    private Long id;
    private String description;
    private String technologie;
    private Long cout;
    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    @OneToOne
    private Projet projet;

}
