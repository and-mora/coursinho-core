package it.amorabito.coursinho.model.dtos;

import it.amorabito.coursinho.model.entities.CourseEdition;
import it.amorabito.coursinho.model.entities.Teacher;
import it.amorabito.coursinho.model.entities.Module;

public class ModuleDto {

    public ModuleDto() {
    }

    public ModuleDto(Module module) {
        this.id = module.getId();
        this.name = module.getName();
        this.description = module.getDescription();
        this.teacherId = module.getTeacher().getId();
        this.teacherName = module.getTeacher().getFirstName() + "," + module.getTeacher().getLastName();
        this.duration = module.getDuration();
        this.editionId = module.getEdition().getId();
    }

    public Module toModule() {
        Module module = new Module();
        module.setId(this.getId());
        module.setName(this.getName());
        module.setDescription(this.getDescription());
        module.setDuration(this.getDuration());

        Teacher t = new Teacher();
        t.setId(this.getTeacherId());
        module.setTeacher(t);

        CourseEdition ce = new CourseEdition();
        ce.setId(this.getEditionId());
        module.setEdition(ce);

        return module;
    }

    private long id;

    private String name;

    private String description;

    private long teacherId;

    private String teacherName;

    private int duration;

    private long editionId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public long getEditionId() {
        return editionId;
    }

    public void setEditionId(long editionId) {
        this.editionId = editionId;
    }
}
