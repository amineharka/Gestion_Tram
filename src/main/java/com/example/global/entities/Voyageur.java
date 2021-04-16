package com.example.global.entities;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("3")
@Data
@Component
public class Voyageur extends User{

    @OneToOne(optional = false)
    @JoinColumn(name = "tramSolde_id", referencedColumnName = "id")
    private TramSolde tramSolde_attaché ;

    @OneToMany(mappedBy = "voyageur")
    List<Alimentation> alimentationList ;


}
