package it.amorabito.coursinho.entities;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "weekly_session")
public class WeeklySession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private DayWeek day;
    
    private LocalTime start;
    private LocalTime end;

    @ManyToOne(cascade = {})
    @JoinColumn(name = "edition_id")
    private CourseEdition edition;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public DayWeek getDay() {
        return day;
    }

    public void setDay(DayWeek day) {
        this.day = day;
    }

    public LocalTime getStart() {
        return start;
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }

    public LocalTime getEnd() {
        return end;
    }

    public void setEnd(LocalTime end) {
        this.end = end;
    }

    public CourseEdition getEdition() {
        return edition;
    }

    public void setEdition(CourseEdition edition) {
        this.edition = edition;
    }
}
