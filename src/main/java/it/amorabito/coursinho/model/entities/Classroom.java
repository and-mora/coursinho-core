package it.amorabito.coursinho.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "classroom_type")
@Table(name = "classroom")
@Getter
@Setter
public abstract class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String title;
    private int capacity;

    public abstract boolean hasComputer();

    public abstract boolean hasProjectors();
}
