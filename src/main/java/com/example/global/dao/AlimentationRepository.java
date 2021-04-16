package com.example.global.dao;

import com.example.global.entities.Alimentation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlimentationRepository extends JpaRepository<Alimentation,Long> {
}
