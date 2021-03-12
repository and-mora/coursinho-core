package it.bit.academy.corsopiu.dtos;

import it.bit.academy.corsopiu.entities.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CourseDto {
    
    private long id;
    private String name;
    private int duration;
    private double price;
    private String program;
    private boolean certification;
    private String category;
    private List<CourseEditionDto> editions;

    CourseDto() {
    }

    public CourseDto(Course course) {
        this.id = course.getId();
        this.name = course.getName();
        this.duration = course.getDuration();
        this.price = course.getPrice();
        this.program = course.getProgram();
        this.certification = course.isCertification();
        this.category = course.getCategory();
        this.editions = course.getEditions().stream().map(CourseEditionDto::new).collect(Collectors.toList());
    }

    public Course toCourse() {
        Course course = new Course();
        course.setId(this.getId());
        course.setName(this.getName());
        course.setDuration(this.getDuration());
        course.setPrice(this.getPrice());
        course.setProgram(this.getProgram());
        course.setCertification(this.isCertification());
        course.setCategory(this.getCategory());
        course.setEditions(new ArrayList<>());
        return course;
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

    public List<CourseEditionDto> getEditions() {
        return editions;
    }

    public void setEditions(List<CourseEditionDto> editions) {
        this.editions = editions;
    }
}
