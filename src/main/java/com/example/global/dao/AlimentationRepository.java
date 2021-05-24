package com.example.global.dao;

import com.example.global.entities.Alimentation;
import com.example.global.entities.Voyageur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlimentationRepository extends JpaRepository<Alimentation,Long> {
    List<Alimentation> findByVoyageur(Voyageur loggedVoyageur);
}
