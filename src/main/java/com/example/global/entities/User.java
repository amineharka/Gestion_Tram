package com.example.global.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="user_type", discriminatorType = DiscriminatorType.STRING)
@Getter @Setter @NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String nom ;
    private String prenom ;
    private String gmail ;
    private String cin ;
    private String password ;
    private String sexe ;
    private String phone ;
    private Boolean enabled ;
    private Instant created ;
    private String username ;
    @Column(name="myrole")
    private String role ;
    private String imageUrl;

    public User(String nom ,String prenom,String gmail,String cin,String password,String sexe,String phone)
    {
        this.nom = nom ;
        this.prenom = prenom ;
        this.gmail = gmail ;
        this.cin = cin ;
        this.password = password ;
        this.sexe = sexe ;
        this.phone = phone ;
    }
}
