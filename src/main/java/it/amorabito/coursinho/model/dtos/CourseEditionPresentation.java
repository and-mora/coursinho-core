package it.amorabito.coursinho.model.dtos;

import lombok.Data;

@Data
public class CourseEditionPresentation {

    private long courseId;
    private long courseEditionId;
    private String name;
    private String category;
    private double price;
}
