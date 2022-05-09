package it.amorabito.coursinho.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "application")
@Getter
@Setter
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
}
