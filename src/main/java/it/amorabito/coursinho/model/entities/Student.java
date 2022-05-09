package it.amorabito.coursinho.model.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("STUD")
@Getter
@Setter
public class Student extends Person {

    public Student(String name, String surname, Gender gender) {
        super(name, surname, gender);
    }

    public Student() {
    }

    @OneToMany(mappedBy = "student",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.REMOVE})
    private List<Application> applications;
}
