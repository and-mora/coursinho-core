package it.amorabito.coursinho.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "course")
@Getter
@Setter
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "duration")
    private int duration;

    @Column(name = "price")
    private double price;

    @Column(name = "program")
    private String program;

    @Column(name = "certification")
    private boolean certification;

    @Column(name = "category")
    private String category;

    @OneToMany(mappedBy = "course",
            cascade = {CascadeType.REMOVE, CascadeType.PERSIST,
                    CascadeType.MERGE})
    private List<CourseEdition> editions;
}
