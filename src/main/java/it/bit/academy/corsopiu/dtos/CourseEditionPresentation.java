package it.bit.academy.corsopiu.dtos;

public class CourseEditionPresentation {

    private long courseId;
    private long courseEditionId;
    private String name;
    private String category;

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public long getCourseEditionId() {
        return courseEditionId;
    }

    public void setCourseEditionId(long courseEditionId) {
        this.courseEditionId = courseEditionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
