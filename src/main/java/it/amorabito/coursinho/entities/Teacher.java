package it.amorabito.coursinho.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("TEACH")
public class Teacher extends Person {

    @Column(name = "hourly_wage")
    private double hourlyWage;

    public double getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }
}
