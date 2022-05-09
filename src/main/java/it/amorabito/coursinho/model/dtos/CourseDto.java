package it.amorabito.coursinho.model.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CourseDto {

    @EqualsAndHashCode.Include
    private long id;
    private String name;
    private int duration;
    private double price;
    private String program;
    private boolean certification;
    private String category;
    private List<CourseEditionDto> editions;
}
