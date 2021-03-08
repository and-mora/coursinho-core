package it.bit.academy.corsopiu.entities;

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
}
