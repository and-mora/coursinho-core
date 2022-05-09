package it.amorabito.coursinho.model.dtos;

import it.amorabito.coursinho.model.entities.Level;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class SkillDto {

    @EqualsAndHashCode.Include
    private long id;
    private long abilityId;
    private String abilityName;
    private String abilityDescription;
    private long areaId;
    private String areaName;
    private String areaDescription;
    private Level level;
    private boolean certified;
    private long personId;
}
