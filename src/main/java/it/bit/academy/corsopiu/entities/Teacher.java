package it.bit.academy.corsopiu.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("TEACH")
public class Teacher extends Person{

    @Column(name = "hourly_wage")
    private double hourlyWage;
}
