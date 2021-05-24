package com.example.global;

import com.example.global.dao.*;
import com.example.global.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Date;

@SpringBootApplication
public class GlobalApplication implements CommandLineRunner {

	@Autowired
	private ResponsableGuichetRepository rgp ;
	@Autowired
	private AdministrateurRepository ap ;
	@Autowired
    private PasswordEncoder passwordEncoder;
	@Autowired
	private VoyageurRepository voyageurRepository;
	@Autowired
	private AlimentationRepository alimentationRepository;
	@Autowired
	private TramSoldeRepository tramSoldeRepository;
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(GlobalApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*").allowedMethods("PUT","DELETE","POST","GET"
						,"OPTIONS","HEAD");
			}
		};
	}

	@Override
	public void run(String... args) throws Exception {
		User user = userRepository.findByGmail("admin@gmail.com");
		System.out.println(user.getRole());
		System.out.println(user.getSexe());

	}
}
