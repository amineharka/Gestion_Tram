package com.example.global.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor
@Component
public class Ligne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String label ;

    @JsonIgnore
    @OneToMany(mappedBy = "ligne")
    List<Station> stationList;



    public Ligne(String label)
    {
        this.label = label;
    }
}
