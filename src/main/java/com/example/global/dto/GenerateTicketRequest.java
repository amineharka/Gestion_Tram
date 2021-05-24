package com.example.global.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class GenerateTicketRequest {

    private int nombre ;
    private String ligne ;
    private float prix ;
}
