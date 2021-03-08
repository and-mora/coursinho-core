package it.bit.academy.corsopiu.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("REAL")
public class RealClassroom extends Classroom{

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

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }
}
