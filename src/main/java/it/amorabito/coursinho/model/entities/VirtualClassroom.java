package it.amorabito.coursinho.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("VIRT")
@Getter
@Setter
public class VirtualClassroom extends Classroom {

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
