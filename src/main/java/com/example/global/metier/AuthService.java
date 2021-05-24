package com.example.global.metier;

import com.example.global.dao.TramSoldeRepository;
import com.example.global.dao.UserRepository;
import com.example.global.dao.VoyageurRepository;
import com.example.global.dto.LoginRequest;
import com.example.global.dto.RegisterRequest;
import com.example.global.entities.TramSolde;
import com.example.global.entities.User;
import com.example.global.entities.Voyageur;
import com.example.global.util.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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
    private final AuthenticationManager authenticationManager ;
    private final JwtUtil jwtUtil ;





    public void signup(RegisterRequest registerRequest) {
        Voyageur voyageur = new Voyageur();
        TramSolde tramSolde = new TramSolde();


        voyageur.setNom(registerRequest.getNom());
        voyageur.setPrenom(registerRequest.getPrenom());
        voyageur.setCin(registerRequest.getCin());
        voyageur.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        voyageur.setGmail(registerRequest.getGmail());
        voyageur.setSexe(registerRequest.getSexe());
        voyageur.setPhone(registerRequest.getPhone());
        voyageur.setEnabled(false);
        voyageur.setRole("voyageur");
        voyageur.setCreated(Instant.now());
        tramSoldeRepository.save(tramSolde);
        voyageur.setTramSolde_attaché(tramSolde);

        voyageurRepository.save(voyageur);
    }



    public String login2(LoginRequest loginRequest) throws Exception
    {
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getGmail(),loginRequest.getPassword())
            );
        }
        catch (Exception ex)
        {
            throw new Exception("invalidate gmail or password");
        }

        return jwtUtil.generateToken(loginRequest.getGmail(),userRepository.findByGmail(loginRequest.getGmail()).getRole());
    }
}
