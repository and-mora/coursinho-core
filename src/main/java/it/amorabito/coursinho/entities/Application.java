package it.amorabito.coursinho.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "application")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String comments;

    @Column(name = "application_date")
    private LocalDateTime applicationDate;

    @Column(name = "application_state")
    @Enumerated(EnumType.STRING)
    private ProcessingState applicationState;

    @ManyToOne()
    @JoinColumn(name = "edition_id")
    private CourseEdition edition;

    @ManyToOne()
    @JoinColumn(name = "student_id")
    private Student student;

    public String getComments() {
        return comments;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public CourseEdition getEdition() {
        return edition;
    }

    public void setEdition(CourseEdition edition) {
        this.edition = edition;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
