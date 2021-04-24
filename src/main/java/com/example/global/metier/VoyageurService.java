package com.example.global.metier;

import com.example.global.dao.AlimentationRepository;
import com.example.global.dao.TramSoldeRepository;
import com.example.global.dao.VoyageurRepository;
import com.example.global.dto.AlimenterRequest;
import com.example.global.entities.Alimentation;
import com.example.global.entities.Voyageur;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
@AllArgsConstructor
public class VoyageurService {
    private final AlimentationRepository alimentationRepository ;
    private final VoyageurRepository voyageurRepository ;
    private final TramSoldeRepository tramSoldeRepository ;
    public List<Alimentation> getAllAlimentationByVoyageur(Long id)
    {
        Voyageur voyageur = voyageurRepository.findById(id).get();
        return voyageur.getAlimentationList();
    }

    public Alimentation alimenter(AlimenterRequest alimenterRequest)
    {
        float montant = alimenterRequest.getMontant();
        Long id = alimenterRequest.getId();
        Alimentation alimentation = new Alimentation(montant,new Date());
        Voyageur voyageur = voyageurRepository.findById(id).get();
        alimentation.setVoyageur(voyageur);
        alimentation.setTramSolde(voyageur.getTramSolde_attaché());
        voyageur.getTramSolde_attaché().setSolde(voyageur.getTramSolde_attaché().getSolde()+montant);
        tramSoldeRepository.save(voyageur.getTramSolde_attaché());
        alimentationRepository.save(alimentation);
        return alimentation ;

    }
}
