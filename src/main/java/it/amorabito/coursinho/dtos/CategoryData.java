package it.amorabito.coursinho.dtos;

public class CategoryData {

    public CategoryData(String name, long numCourses){
        this.name = name;
        this.numCourses = numCourses;
    }

    private String name;
    private long numCourses;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNumCourses() {
        return numCourses;
    }

    public void setNumCourses(long numCourses) {
        this.numCourses = numCourses;
    }
}
