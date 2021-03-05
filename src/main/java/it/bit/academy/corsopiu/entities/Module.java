package it.bit.academy.corsopiu.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "module")
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private Person teacher;
    private int durationHours;

    private List<Lesson> lessons;
    private String description;

    @ManyToOne(cascade = {})
    @JoinColumn(name = "edition_id")
    private CourseEdition edition;
}
