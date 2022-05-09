package it.amorabito.coursinho.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "course_edition")
@Getter
@Setter
public class CourseEdition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "start_date")
    private LocalDate startDate;

    @ManyToOne
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;     // aula in cui si svolge il corso

    @OneToMany(mappedBy = "edition",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.REMOVE, CascadeType.PERSIST,
                    CascadeType.MERGE})
    private List<Application> applications;   // elenco partecipanti

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "edition",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.REMOVE, CascadeType.PERSIST,
                    CascadeType.MERGE})
    private List<Module> modules;

    @OneToMany(mappedBy = "edition",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.REMOVE, CascadeType.PERSIST,
                    CascadeType.MERGE})
    private List<WeeklySession> weeklySessions;  // quando dovrebbero sostenersi le lezioni

    @ManyToOne
    @JoinColumn(name = "tutor_id")
    private Person tutor;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}
