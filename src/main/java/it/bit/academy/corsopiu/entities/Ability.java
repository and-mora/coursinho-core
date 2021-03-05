package it.bit.academy.corsopiu.entities;

import javax.persistence.*;

@Entity
@Table(name = "ability")
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
