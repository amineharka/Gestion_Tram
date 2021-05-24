package com.example.global.dao;

import com.example.global.entities.Ligne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneRepository extends JpaRepository<Ligne,Long> {

    Ligne findByLabel(String ligne);
}
