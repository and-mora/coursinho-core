package it.amorabito.coursinho.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("REAL")
@Getter
@Setter
public class RealClassroom extends Classroom {

    @Enumerated(EnumType.STRING)
    private Equipment equipment;

    @Override
    public boolean hasComputer() {
        return equipment == Equipment.PC || equipment == Equipment.FULL;
    }

    @Override
    public boolean hasProjectors() {
        return equipment == Equipment.PROJECTOR || equipment == Equipment.FULL;
    }
}
