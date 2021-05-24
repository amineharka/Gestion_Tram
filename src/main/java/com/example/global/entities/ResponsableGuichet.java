package com.example.global.entities;

import org.springframework.stereotype.Component;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("responsable")
public class ResponsableGuichet extends User{
    private String agence ;

    public ResponsableGuichet()
    {
        this.setRole("responsable");
    }

}


