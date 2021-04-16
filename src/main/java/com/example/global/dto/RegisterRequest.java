package com.example.global.dto;

import lombok.Data;

@Data
public class RegisterRequest {
    private String nom ;
    private String prenom ;
    private String gmail ;
    private String cin ;
    private String password ;
    private String sexe ;
    private String phone ;

}
