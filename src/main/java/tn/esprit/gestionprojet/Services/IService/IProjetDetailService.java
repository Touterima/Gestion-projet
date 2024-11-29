package tn.esprit.gestionprojet.Services.IService;
import tn.esprit.gestionprojet.Entities.ProjetDetail;

import java.util.List;

public interface IProjetDetailService {
    List<ProjetDetail> findAllProjetDetail();
    ProjetDetail findProjetDetailById(Long id);
    ProjetDetail saveProjetDetail(ProjetDetail projetDetail);
    ProjetDetail updateProjetDetail(ProjetDetail projetDetail);
    void deleteProjetDetail(Long id);

}
