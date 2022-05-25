package it.amorabito.coursinho.model.dtos;

import it.amorabito.coursinho.model.entities.Address;
import it.amorabito.coursinho.model.entities.Gender;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PersonDto {

    public PersonDto() {
    }

    @EqualsAndHashCode.Include
    private long id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private String email;
    private String phone;
    private LocalDate birthDate;
    private String birthPlace;
    private String fiscalCode;
    private Address address;
    private PersonType personType;
    private String role;
    private double salary;
    private double hourlyWage;
}
