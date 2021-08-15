package it.amorabito.coursinho.dtos;

import it.amorabito.coursinho.entities.Classroom;
import it.amorabito.coursinho.entities.Equipment;
import it.amorabito.coursinho.entities.RealClassroom;
import it.amorabito.coursinho.entities.VirtualClassroom;

public class ClassroomDto {

    public ClassroomDto(Classroom classroom) {
        this.id = classroom.getId();
        this.name = classroom.getName();
        this.title = classroom.getTitle();
        this.capacity = classroom.getCapacity();

        if (classroom instanceof RealClassroom) {
            RealClassroom r = (RealClassroom) classroom;
            this.classroomType = ClassroomType.REAL;
            this.equipment = r.getEquipment();
        } else {
            VirtualClassroom v = (VirtualClassroom) classroom;
            this.classroomType = ClassroomType.VIRT;
            this.link = v.getLink();
            this.platform = v.getPlatform();
            this.password = v.getPassword();
        }
    }

    public Classroom toClassroom() {
        Classroom classroom = null;
        switch (this.getClassroomType()) {
            case REAL:
                classroom = new RealClassroom();
                RealClassroom real = (RealClassroom) classroom;
                real.setEquipment(this.getEquipment());
                break;
            case VIRT:
                classroom = new VirtualClassroom();
                VirtualClassroom virt = (VirtualClassroom) classroom;
                virt.setLink(this.getLink());
                virt.setPassword(this.getPassword());
                virt.setPlatform(this.getPlatform());
                break;
            default:
                break;
        }

        classroom.setId(this.getId());
        classroom.setCapacity(this.getCapacity());
        classroom.setTitle(this.getTitle());
        classroom.setName(this.getName());

        return classroom;
    }

    private long id;
    private String name;
    private String title;
    private int capacity;
    private ClassroomType classroomType;
    private String platform;
    private String link;
    private String password;
    private Equipment equipment;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public ClassroomType getClassroomType() {
        return classroomType;
    }

    public void setClassroomType(ClassroomType classroomType) {
        this.classroomType = classroomType;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }
}
