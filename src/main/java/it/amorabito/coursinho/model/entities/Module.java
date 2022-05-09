package it.amorabito.coursinho.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "module")
@Getter
@Setter
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Person teacher;

    @Column(name = "duration")
    private int duration;

    @OneToMany(mappedBy = "module")
    private List<Lesson> lessons;

    @ManyToOne
    @JoinColumn(name = "edition_id")
    private CourseEdition edition;
}
