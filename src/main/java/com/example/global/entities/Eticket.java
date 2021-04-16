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
public class Eticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String code ;
    private float prix ;
    private Date date ;
    private String status ;

    @ManyToOne(optional = false)
    @JoinColumn(name = "tramSolde_id", referencedColumnName = "id")
    private TramSolde tramSolde;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ligne_id", referencedColumnName = "id")
    private Ligne ligne;





    public Eticket(String code,float prix,Date date ,String status)
    {
        this.code = code ;
        this.prix = prix ;
        this.date = date ;
        this.status = status ;
    }
}
