package com.example.global.metier;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class UtilService {

    @Bean
    public String generatePassword()
    {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%&*?";
        String password = RandomStringUtils.random( 15, characters );
        return password;
    }
}
