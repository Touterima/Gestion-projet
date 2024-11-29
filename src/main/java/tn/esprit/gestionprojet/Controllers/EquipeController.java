package tn.esprit.gestionprojet.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionprojet.Entities.Equipe;
import tn.esprit.gestionprojet.Services.EquipeService;

import java.util.List;

@RestController
@RequestMapping("/api/equipes")
@RequiredArgsConstructor
public class EquipeController {
    private final EquipeService equipeService;

    @GetMapping
    public ResponseEntity<List<Equipe>> getAllEquipes() {
        List<Equipe> equipes = equipeService.findAllEquipes();
        return ResponseEntity.ok(equipes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipe> getEquipeById(@PathVariable int id) {
        Equipe equipe = equipeService.findEquipeById(id);
        return ResponseEntity.ok(equipe);
    }

    @PostMapping
    public ResponseEntity<Equipe> addEquipe(@RequestBody Equipe equipe) {
        Equipe savedEquipe = equipeService.addEquipe(equipe);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEquipe);
    }

    @PutMapping
    public ResponseEntity<Equipe> updateEquipe(@RequestBody Equipe equipe) {
        Equipe updatedEquipe = equipeService.updateEquipe(equipe);
        return ResponseEntity.ok(updatedEquipe);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEquipe(@PathVariable int id) {
        equipeService.deleteEquipe(id);
        return ResponseEntity.noContent().build();
    }
}

