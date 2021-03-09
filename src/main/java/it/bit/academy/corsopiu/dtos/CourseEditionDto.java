package it.bit.academy.corsopiu.dtos;

import it.bit.academy.corsopiu.entities.*;

import java.time.LocalDate;

public class CourseEditionDto {

    public CourseEditionDto() {
    }

    public CourseEditionDto(CourseEdition ce) {
        this.id = ce.getId();
        this.startDate = ce.getStartDate();
        this.classroomId = ce.getClassroom().getId();
        this.classroomName = ce.getClassroom().getName();
        this.description = ce.getDescription();
        this.tutorId = ce.getTutor().getId();
        this.tutorName = ce.getTutor().getFirstName() + " " + ce.getTutor().getLastName();
        this.courseId = ce.getCourse().getId();
    }

    public CourseEdition toCourseEdition() {
        CourseEdition courseEdition = new CourseEdition();
        courseEdition.setId(this.getId());
        courseEdition.setStartDate(this.getStartDate());
        courseEdition.setDescription(this.getDescription());

        Person person = new Employee();
        person.setId(this.getTutorId());
        courseEdition.setTutor(person);

        Course course = new Course();
        course.setId(this.getCourseId());
        courseEdition.setCourse(course);

        Classroom classroom = new RealClassroom();
        classroom.setId(this.getClassroomId());
        courseEdition.setClassroom(classroom);

        return courseEdition;
    }

    private long id;

    private LocalDate startDate;

    private long classroomId;     // aula in cui si svolge il corso

    private String classroomName;

    private String description;

    private long tutorId;

    private String tutorName;

    private long courseId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public long getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(long classroomId) {
        this.classroomId = classroomId;
    }

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getTutorId() {
        return tutorId;
    }

    public void setTutorId(long tutorId) {
        this.tutorId = tutorId;
    }

    public String getTutorName() {
        return tutorName;
    }

    public void setTutorName(String tutorName) {
        this.tutorName = tutorName;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }
}
