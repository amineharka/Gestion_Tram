package com.example.global.dao;

import com.example.global.entities.Voyageur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoyageurRepository extends JpaRepository<Voyageur,Long> {
    Voyageur findByGmail(String username);
}
