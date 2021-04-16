package com.example.global.metier;

import com.example.global.dao.TramSoldeRepository;
import com.example.global.dao.UserRepository;
import com.example.global.dao.VoyageurRepository;
import com.example.global.dto.LoginRequest;
import com.example.global.dto.RegisterRequest;
import com.example.global.entities.TramSolde;
import com.example.global.entities.User;
import com.example.global.entities.Voyageur;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AuthService {
    private final PasswordEncoder passwordEncoder;
    private final VoyageurRepository voyageurRepository;
    private final UserRepository userRepository ;
    private final TramSoldeRepository tramSoldeRepository;
    @Autowired
    Voyageur voyageur ;
    @Autowired
    TramSolde tramSolde ;



    public void signup(RegisterRequest registerRequest) {

        voyageur.setNom(registerRequest.getNom());
        voyageur.setPrenom(registerRequest.getPrenom());
        voyageur.setCin(registerRequest.getCin());
        voyageur.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        voyageur.setGmail(registerRequest.getGmail());
        voyageur.setSexe(registerRequest.getSexe());
        voyageur.setPhone(registerRequest.getPhone());
        voyageur.setEnabled(false);
        voyageur.setCreated(Instant.now());
        tramSoldeRepository.save(tramSolde);
        voyageur.setTramSolde_attaché(tramSolde);

        voyageurRepository.save(voyageur);
    }

    public User login(LoginRequest loginRequest)
    {
        User user = userRepository.findByGmail(loginRequest.getGmail());

        if(passwordEncoder.matches(loginRequest.getPassword(),user.getPassword()))
        {
            return user ;
        }

        return null;
    }
}
