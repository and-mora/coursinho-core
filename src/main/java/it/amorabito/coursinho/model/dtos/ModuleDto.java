package it.amorabito.coursinho.model.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ModuleDto {

    @EqualsAndHashCode.Include
    private long id;
    private String name;
    private String description;
    private long teacherId;
    private String teacherName;
    private int duration;
    private long editionId;
}
