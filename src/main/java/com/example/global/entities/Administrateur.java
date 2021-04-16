package com.example.global.entities;

import org.springframework.stereotype.Component;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@DiscriminatorValue("1")
@Entity
@Component
public class Administrateur extends User{
}
