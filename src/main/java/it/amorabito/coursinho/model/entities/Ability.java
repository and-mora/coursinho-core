package it.amorabito.coursinho.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ability")
@Getter
@Setter
public class Ability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;    // ex. programmazione java, impaginazione, grafica pubblicitaria.

    @ManyToOne
    @JoinColumn(name = "area_id")
    private Area area;

    private String description;
}
