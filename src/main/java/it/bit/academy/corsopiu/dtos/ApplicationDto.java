package it.bit.academy.corsopiu.dtos;

import it.bit.academy.corsopiu.entities.Application;
import it.bit.academy.corsopiu.entities.CourseEdition;
import it.bit.academy.corsopiu.entities.ProcessingState;
import it.bit.academy.corsopiu.entities.Student;

import java.time.LocalDateTime;

public class ApplicationDto {

    public ApplicationDto() {
    }

    public ApplicationDto(Application application) {
        this.id = application.getId();
        this.comments = application.getComments();
        this.applicationDate = application.getApplicationDate();
        this.applicationState = application.getApplicationState();
        this.editionId = application.getEdition().getId();
        this.studentId = application.getStudent().getId();
        this.studentName = application.getStudent().getFirstName()+","+application.getStudent().getLastName();
    }

    public Application toApplication() {
        Application appl = new Application();
        appl.setId(this.getId());
        appl.setComments(this.getComments());
        appl.setApplicationDate(this.getApplicationDate());
        appl.setApplicationState(this.getApplicationState());

        CourseEdition ce = new CourseEdition();
        ce.setId(this.getEditionId());
        appl.setEdition(ce);

        Student st = new Student();
        st.setId(this.getStudentId());
        appl.setStudent(st);

        return appl;
    }

    private long id;
    private String comments;
    private LocalDateTime applicationDate;
    private ProcessingState applicationState;
    private long editionId;
    private long studentId;
    private String studentName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public LocalDateTime getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(LocalDateTime applicationDate) {
        this.applicationDate = applicationDate;
    }

    public ProcessingState getApplicationState() {
        return applicationState;
    }

    public void setApplicationState(ProcessingState applicationState) {
        this.applicationState = applicationState;
    }

    public long getEditionId() {
        return editionId;
    }

    public void setEditionId(long editionId) {
        this.editionId = editionId;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
