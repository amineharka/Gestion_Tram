package com.example.global.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Getter @Setter @NoArgsConstructor
@Component
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String label ;
    private String premierDepart ;
    private String dernierDepart ;


    @ManyToOne(optional = false)
    @JoinColumn(name="ligne_id",referencedColumnName = "id")
    private Ligne ligne;



    public Station(String label ,String premierDepart,String dernierDepart)
    {
        this.label = label ;
        this.premierDepart = premierDepart ;
        this.dernierDepart = dernierDepart ;
    }
}
