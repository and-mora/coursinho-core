package it.amorabito.coursinho.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("EMPL")
@Getter
@Setter
public class Employee extends Person {

    private String role;
    private double salary;
}
