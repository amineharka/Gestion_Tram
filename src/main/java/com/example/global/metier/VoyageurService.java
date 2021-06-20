package com.example.global.metier;

import com.example.global.dao.*;
import com.example.global.dto.AlimenterRequest;
import com.example.global.dto.GenerateTicketRequest;
import com.example.global.dto.GlobaIinformation;
import com.example.global.entities.Alimentation;
import com.example.global.entities.Eticket;
import com.example.global.entities.TramSolde;
import com.example.global.entities.Voyageur;
import com.example.global.util.LuhnUtil;
import com.example.global.util.TrackerUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class VoyageurService {
    private final AlimentationRepository alimentationRepository ;
    private final VoyageurRepository voyageurRepository ;
    private final TramSoldeRepository tramSoldeRepository ;
    private final LigneRepository ligneRepository;
    private final EticketRepository eticketRepository;
    private final TrackerUtil trackerUtil;
    private final LuhnUtil luhnUtil ;
    private final EmailService emailService ;


    public Alimentation alimenter(AlimenterRequest alimenterRequest)
    {

        float montant = alimenterRequest.getMontant();
        Alimentation alimentation = new Alimentation(montant,new Date());
        Voyageur voyageur = trackerUtil.getLoggedVoyageur();
        alimentation.setVoyageur(voyageur);
        alimentation.setTramSolde(voyageur.getTramSolde_attaché());
        voyageur.getTramSolde_attaché().setSolde(voyageur.getTramSolde_attaché().getSolde()+montant);

        if(luhnUtil.validateCreditCardNumber(alimenterRequest.getCardNumber()))
        {
            tramSoldeRepository.save(voyageur.getTramSolde_attaché());
            alimentationRepository.save(alimentation);
            /*send email of success operation after alimentation */
            String subject ="Payement réussite";
            String text = "Bonjour,\n\nvotre alimentation de compte tramway solde a bien reussi\nmontant : "+montant +"\nMerci pour votre confiance";
            emailService.sendSimpleMessage(voyageur.getGmail(),subject,text);
        }


        return alimentation ;

    }

    public String generatetickets(GenerateTicketRequest gtr)
    {
        Voyageur voyageur = trackerUtil.getLoggedVoyageur();
        TramSolde tramSolde = trackerUtil.getLoggedVoyageur().getTramSolde_attaché();
        if(tramSolde.getSolde()>gtr.getPrix()*gtr.getNombre())
        {
            for(int i=0;i<gtr.getNombre();i++) {
                Eticket ticket = new Eticket();
                ticket.setDate(new Date());
                ticket.setLigne(ligneRepository.findByLabel(gtr.getLigne()));
                ticket.setTramSolde(voyageur.getTramSolde_attaché());
                ticket.setPrix(gtr.getPrix());

                tramSolde.setSolde(tramSolde.getSolde() - gtr.getPrix());
                tramSoldeRepository.save(tramSolde);
                eticketRepository.save(ticket);

            }
            return "reussite";

        }
        else{
            return "votre solde n'est pas suiffisant pour acheter ce nombre de  tickets" ;
        }


    }

    public List<Eticket> getAllTickets()
    {
        return eticketRepository.findByTramSolde(trackerUtil.getLoggedVoyageur().getTramSolde_attaché());
    }

    public List<Alimentation> getMyAlimentation()
    {
        return alimentationRepository.findByVoyageur(trackerUtil.getLoggedVoyageur());
    }

    public GlobaIinformation getInfo() {
        GlobaIinformation gi = new GlobaIinformation();
        Voyageur voyageur = trackerUtil.getLoggedVoyageur();
        gi.setSolde(voyageur.getTramSolde_attaché().getSolde());
        gi.setTicket_v(eticketRepository.findByTramSoldeAndStatus(voyageur.getTramSolde_attaché(),"valide"));
        gi.setTicket_nv(eticketRepository.findByTramSoldeAndStatus(voyageur.getTramSolde_attaché(),"Non_valide"));
        gi.setAlimentations(voyageur.getAlimentationList());
        gi.setEtickets(voyageur.getTramSolde_attaché().getEticketList());
        return gi;
    }
}
