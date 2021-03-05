package it.bit.academy.corsopiu.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "application")
public class Application {

    @ManyToOne()
    @JoinColumn(name = "edition_id")
    private CourseEdition edition;

    @ManyToOne()
    @JoinColumn(name = "student_id")
    private Student student;

    @Column(name = "application_date")
    private LocalDateTime applicationDate;

    @Column(name = "application_state")
    private ProcessingState applicationState;

    private String comments;
}
