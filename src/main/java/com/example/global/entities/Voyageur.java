package com.example.global.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("voyageur")
@Data
public class Voyageur extends User{

    @OneToOne
    @JoinColumn(name = "tramSolde_id", referencedColumnName = "id")
    @JsonIgnore
    private TramSolde tramSolde_attaché ;

    @OneToMany(mappedBy = "voyageur")
    @JsonIgnore
    List<Alimentation> alimentationList ;

    public Voyageur()
    {
        this.setRole("voyageur");
    }


}
