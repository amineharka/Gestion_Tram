package com.example.global.dto;

import lombok.AllArgsConstructor;

import java.util.Map;
@AllArgsConstructor
public class CustomResponse {
    private Map errors ;
    private Object response ;
}
