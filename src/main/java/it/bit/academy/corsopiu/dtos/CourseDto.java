package it.bit.academy.corsopiu.dtos;

import it.bit.academy.corsopiu.entities.Course;

public class CourseDto {

    private long id;
    private String name;
    private int duration;
    private double price;
    private String program;
    private boolean certification;
    private String category;

    public CourseDto(Course course) {
        this.id = course.getId();
        this.name = course.getName();
        this.duration = course.getDuration();
        this.price = course.getPrice();
        this.program = course.getProgram();
        this.certification = course.isCertification();
        this.category = course.getCategory();
    }
}
