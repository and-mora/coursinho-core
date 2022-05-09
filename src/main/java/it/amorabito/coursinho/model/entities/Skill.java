package it.amorabito.coursinho.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "skill")
@Getter
@Setter
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "ability_id")
    private Ability ability;

    @Enumerated(EnumType.STRING)
    private Level level;

    private boolean certified;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
}
