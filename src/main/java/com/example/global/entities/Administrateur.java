package com.example.global.entities;

import org.springframework.stereotype.Component;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@DiscriminatorValue("admin")
@Entity
public class Administrateur extends User{

    public Administrateur()
    {
        this.setRole("admin");
    }
}
