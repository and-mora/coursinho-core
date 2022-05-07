package it.amorabito.coursinho.model.dtos;

import java.util.List;


public class CourseDto {

    private long id;
    private String name;
    private int duration;
    private double price;
    private String program;
    private boolean certification;
    private String category;
    private List<CourseEditionDto> editions;

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
