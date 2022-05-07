package it.amorabito.coursinho.model.dtos;

import it.amorabito.coursinho.model.entities.Level;

public class SkillDto {

    private long abilityId;
    private String abilityName;
    private String abilityDescription;
    private long areaId;
    private String areaName;
    private String areaDescription;
    private long id;
    private Level level;
    private boolean certified;
    private long personId;


    public long getAbilityId() {
        return abilityId;
    }

    public void setAbilityId(long abilityId) {
        this.abilityId = abilityId;
    }

    public String getAbilityName() {
        return abilityName;
    }

    public void setAbilityName(String abilityName) {
        this.abilityName = abilityName;
    }

    public String getAbilityDescription() {
        return abilityDescription;
    }

    public void setAbilityDescription(String abilityDescription) {
        this.abilityDescription = abilityDescription;
    }

    public long getAreaId() {
        return areaId;
    }

    public void setAreaId(long areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAreaDescription() {
        return areaDescription;
    }

    public void setAreaDescription(String areaDescription) {
        this.areaDescription = areaDescription;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public boolean isCertified() {
        return certified;
    }

    public void setCertified(boolean certified) {
        this.certified = certified;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }
}
