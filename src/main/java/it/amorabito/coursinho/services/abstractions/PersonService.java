package it.amorabito.coursinho.services.abstractions;

import it.amorabito.coursinho.model.dtos.PersonDto;

import java.util.Collection;

public interface PersonService {
    Collection<PersonDto> getPersons();

//    PersonDto savePerson(PersonDto person);

    PersonDto getPersonById(long id);

    Collection<PersonDto> getTeachers();

    Collection<PersonDto> getEmployees();

    Collection<PersonDto> getStudents();

    Collection<PersonDto> getStudentsContaining(String firstName, String lastName, String fiscalCode);

    void deletePerson(long id);
}
