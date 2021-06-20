package com.example.global.dto;

import com.example.global.entities.Alimentation;
import com.example.global.entities.Eticket;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GlobaIinformation {
    private int ticket_v;
    private float solde;
    private int ticket_nv;
    private List<Alimentation> alimentations;
    private List<Eticket> etickets;
}
