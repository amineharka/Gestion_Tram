package com.example.global.dao;

import com.example.global.entities.Eticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EticketRepository extends JpaRepository<Eticket,Long> {
}
