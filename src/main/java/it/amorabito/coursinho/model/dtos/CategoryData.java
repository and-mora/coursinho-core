package it.amorabito.coursinho.model.dtos;

import lombok.Data;

@Data
public class CategoryData {

    private String name;
    private long numCourses;

    public CategoryData(String name, long numCourses) {
        this.name = name;
        this.numCourses = numCourses;
    }
}
