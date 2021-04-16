package com.example.global.entities;

import org.springframework.stereotype.Component;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("2")
@Component
public class ResponsableGuichet extends User{
    private String agence ;
}
