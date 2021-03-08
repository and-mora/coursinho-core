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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public boolean isCertification() {
        return certification;
    }

    public void setCertification(boolean certification) {
        this.certification = certification;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
