package com.example.global.metier;

import com.example.global.dao.LigneRepository;
import com.example.global.dao.TestRepository;
import com.example.global.entities.Ligne;
import com.example.global.entities.Test;
import com.example.global.exceptions.MyEntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TestService {
    private final TestRepository testRepository;
    private final LigneRepository ligneRepository;

    public Ligne getLigneById(Long id)
    {
        return ligneRepository.findById(id).get();
    }

    public Ligne getLigneById2(Long id)
    {
        Optional<Ligne> ligne = ligneRepository.findById(id);
        if (!ligne.isPresent()) {
            throw new MyEntityNotFoundException(Ligne.class, "id", id.toString());
        }

        return ligne.get() ;

    }


}
