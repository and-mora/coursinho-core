package it.amorabito.coursinho.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "course_edition")
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

    public long getId() {
        return id;
    }

    public List<Application> getApplications() {
        return applications;
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Person getTutor() {
        return tutor;
    }

    public void setTutor(Person tutor) {
        this.tutor = tutor;
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

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

    public List<WeeklySession> getWeeklySessions() {
        return weeklySessions;
    }

    public void setWeeklySessions(List<WeeklySession> weeklySessions) {
        this.weeklySessions = weeklySessions;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
