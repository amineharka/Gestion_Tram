package com.example.global.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor
@Component
public class TramSolde {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private float solde ;



    @OneToOne(mappedBy = "tramSolde_attaché")
    private Voyageur voyageur_concerné;

    @OneToMany(mappedBy = "tramSolde")
    private List<Eticket> eticketList;

    @OneToMany(mappedBy = "tramSolde")
    private List<Alimentation> alimentationList;



    public TramSolde(float solde)
    {
        this.solde = solde ;
    }
}
