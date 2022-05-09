package it.amorabito.coursinho.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "address")
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "street_address")
    private String streetAddress;

    private String city;
    private String province;
    private Region region;

    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;
}
