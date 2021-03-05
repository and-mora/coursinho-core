package it.bit.academy.corsopiu.entities;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "session")
public class Session {

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
