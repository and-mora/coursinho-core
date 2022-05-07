package it.amorabito.coursinho.model.dtos;

import it.amorabito.coursinho.model.entities.*;

public class SkillDto {

    public SkillDto(Skill skill){

        this.abilityId = skill.getAbility().getId();
        this.abilityName = skill.getAbility().getName();
        this.abilityDescription = skill.getAbility().getDescription();
        this.areaId = skill.getAbility().getArea().getId();
        this.areaName = skill.getAbility().getArea().getName();
        this.areaDescription = skill.getAbility().getArea().getDescription();
        this.id = skill.getId();
        this.level = skill.getLevel();
        this.certified = skill.isCertified();
        this.personId = skill.getPerson().getId();

    }

    public Skill toSkill(){
        Skill skill = new Skill();
        skill.setId(this.getId());
        skill.setLevel(this.getLevel());
        skill.setCertified(this.isCertified());

        Ability ability = new Ability();
        ability.setId(this.getAbilityId());
        skill.setAbility(ability);

        Ability area = new Ability();
        area.setId(this.getAreaId());
        skill.setAbility(area);

        Person employee = new Employee();
        employee.setId(this.getPersonId());
        skill.setPerson(employee);

        return skill;
    }

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
