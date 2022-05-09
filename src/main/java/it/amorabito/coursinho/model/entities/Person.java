package it.amorabito.coursinho.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "person_type")
@Table(name = "person")
@Getter
@Setter
public abstract class Person {

    public Person() {
    }

    public Person(String firstName, String lastName, Gender gender) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String email;
    private String phone;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "birth_place")
    private String birthPlace;

    @Column(name = "fiscal_code")
    private String fiscalCode;

    @OneToOne(mappedBy = "person")
    private Address address;

    @OneToMany(mappedBy = "person")
    private List<Skill> skills;
}
