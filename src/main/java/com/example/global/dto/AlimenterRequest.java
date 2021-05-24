package com.example.global.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AlimenterRequest {
    private Long id ;
    private float montant ;
    private String cardNumber ;
}
