package it.amorabito.coursinho.model.dtos;

import lombok.Data;

@Data
public class CourseEditionPresentation {

    private long courseId;
    private long courseEditionId;
    private String courseName;
    private String courseCategory;
    private double coursePrice;
}
