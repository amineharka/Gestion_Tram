package com.example.global.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter @Setter @NoArgsConstructor
@Component
public class Alimentation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private float montant ;
    private Date dateAlimentation ;

    @ManyToOne(optional = false)
    @JoinColumn(name = "tramSolde_id",referencedColumnName = "id")
    private TramSolde tramSolde ;

    @ManyToOne(optional = false)
    @JoinColumn(name = "voyageur_id",referencedColumnName = "id")
    private Voyageur voyageur ;

    public Alimentation(float montant ,Date dateAlimentation)
    {
        this.montant = montant ;
        this.dateAlimentation = dateAlimentation ;
    }
}
