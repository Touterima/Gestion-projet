package tn.esprit.gestionprojet.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionprojet.Entities.ProjetDetail;
import tn.esprit.gestionprojet.Services.ProjetDetailService;

import java.util.List;

@RestController
@RequestMapping("/api/projets/details")
@RequiredArgsConstructor
public class ProjetDetailController {
    private final ProjetDetailService projetDetailService;

    @GetMapping
    public ResponseEntity<List<ProjetDetail>> getAllProjetDetails() {
        List<ProjetDetail> projetDetails = projetDetailService.findAllProjetDetail();
        return ResponseEntity.ok(projetDetails);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjetDetail> getProjetDetailById(@PathVariable Long id) {
        ProjetDetail projetDetail = projetDetailService.findProjetDetailById(id);
        return ResponseEntity.ok(projetDetail);
    }

    @PostMapping
    public ResponseEntity<ProjetDetail> addProjetDetail(@RequestBody ProjetDetail projetDetail) {
        ProjetDetail savedProjetDetail = projetDetailService.saveProjetDetail(projetDetail);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProjetDetail);
    }

    @PutMapping
    public ResponseEntity<ProjetDetail> updateProjetDetail(@RequestBody ProjetDetail projetDetail) {
        ProjetDetail updatedProjetDetail = projetDetailService.updateProjetDetail(projetDetail);
        return ResponseEntity.ok(updatedProjetDetail);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProjetDetail(@PathVariable Long id) {
        projetDetailService.deleteProjetDetail(id);
        return ResponseEntity.noContent().build();
    }
}
