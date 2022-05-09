package it.amorabito.coursinho.model.dtos;

import it.amorabito.coursinho.model.entities.Classroom;
import it.amorabito.coursinho.model.entities.Equipment;
import it.amorabito.coursinho.model.entities.RealClassroom;
import it.amorabito.coursinho.model.entities.VirtualClassroom;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
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

    @EqualsAndHashCode.Include
    private long id;
    private String name;
    private String title;
    private int capacity;
    private ClassroomType classroomType;
    private String platform;
    private String link;
    private String password;
    private Equipment equipment;
}
