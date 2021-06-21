package com.example.global.dao;

import com.example.global.entities.Eticket;
import com.example.global.entities.TramSolde;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EticketRepository extends JpaRepository<Eticket,Long> {
    List<Eticket> findByTramSolde(TramSolde tramSolde_attaché);

    List<Eticket> findByTramSoldeAndStatus(TramSolde tramSolde_attaché, String valide);
}
