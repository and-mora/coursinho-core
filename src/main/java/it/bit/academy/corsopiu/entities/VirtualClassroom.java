package it.bit.academy.corsopiu.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("VIRT")
public class VirtualClassroom extends Classroom{

    private String platform;
    private String link;
    private String password;

    @Override
    public boolean hasComputer() {
        return true;
    }

    @Override
    public boolean hasProjectors() {
        return true;
    }

}
