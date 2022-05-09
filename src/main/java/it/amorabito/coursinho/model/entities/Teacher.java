package it.amorabito.coursinho.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("TEACH")
@Getter
@Setter
public class Teacher extends Person {

    @Column(name = "hourly_wage")
    private double hourlyWage;
}
