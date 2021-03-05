package it.bit.academy.corsopiu.entities;

import javax.persistence.*;

@Entity
@Table(name = "area")
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name; // ex. programmazione, grafica, produttivita
    private String description;

}
