package tn.esprit.gestionprojet.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionprojet.Entities.Projet;
import tn.esprit.gestionprojet.Services.ProjetService;

import java.util.List;

@RestController
@RequestMapping("/api/projets")
@RequiredArgsConstructor
public class ProjetController {
    private final ProjetService projetService;

    @GetMapping
    public ResponseEntity<List<Projet>> getAllProjets() {
        List<Projet> projets = projetService.findAllProjets();
        return ResponseEntity.ok(projets);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Projet> getProjetById(@PathVariable Long id) {
        Projet projet = projetService.findProjetById(id);
        return ResponseEntity.ok(projet);
    }

    @PostMapping
    public ResponseEntity<Projet> addProjet(@RequestBody Projet projet) {
        Projet savedProjet = projetService.addProjet(projet);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProjet);
    }

    @PutMapping
    public ResponseEntity<Projet> updateProjet(@RequestBody Projet projet) {
        Projet updatedProjet = projetService.updateProjet(projet);
        return ResponseEntity.ok(updatedProjet);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProjet(@PathVariable Long id) {
        projetService.deleteProjet(id);
        return ResponseEntity.noContent().build();
    }
}
