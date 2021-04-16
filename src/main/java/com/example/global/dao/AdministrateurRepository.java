package com.example.global.dao;

import com.example.global.entities.Administrateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministrateurRepository extends JpaRepository<Administrateur,Long> {
}
