package com.example.global.metier;

import com.example.global.dao.AlimentationRepository;
import com.example.global.dao.ResponsableGuichetRepository;
import com.example.global.dao.VoyageurRepository;
import com.example.global.dto.MyRequest;
import com.example.global.entities.Alimentation;
import com.example.global.entities.ResponsableGuichet;
import com.example.global.entities.Voyageur;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AdminService {
    private final AlimentationRepository alimentationRepository ;
    private final VoyageurRepository voyageurRepository ;
    private final EmailService emailService ;
    private final PasswordEncoder passwordEncoder ;
    private final ResponsableGuichetRepository responsableGuichetRepository ;
    private final UtilService utilService ;

    public List<Alimentation> getAllAlimentations() {
       return  alimentationRepository.findAll();
    }

    public List<Voyageur> getAllVoyageurs() {
        return  voyageurRepository.findAll();
    }

    public ResponsableGuichet creerRespo(MyRequest myRequest)
    {
        String password = utilService.generatePassword();
        String subject ="Compte Responsable de Guichet";
        String text = "Bonjour,\n\nvotre Login du Plateforme Gestion de Tramway est le suivant \nLogin : "+myRequest.getGmail()+"\nMot de passe : "+password+"\n\nCordialement" ;
        ResponsableGuichet responsableGuichet = new ResponsableGuichet();
        responsableGuichet.setGmail(myRequest.getGmail());
        responsableGuichet.setPassword(passwordEncoder.encode(password));
        responsableGuichet.setRole("responsable");
        responsableGuichetRepository.save(responsableGuichet);
        //Temporairement emailService.sendSimpleMessage(myRequest.getGmail(),subject,text);
        return responsableGuichet ;
    }

    public List<ResponsableGuichet> getAllRespos() {
        return responsableGuichetRepository.findAll();
    }

    public void deleteRespo(Long id) {
        responsableGuichetRepository.deleteById(id);
    }
}
