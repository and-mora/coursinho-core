package it.amorabito.coursinho.model.dtos;

import it.amorabito.coursinho.model.entities.Equipment;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ClassroomDto {

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
