package com.example.global.dao;

import com.example.global.entities.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepository extends JpaRepository<Station,Long> {
}
