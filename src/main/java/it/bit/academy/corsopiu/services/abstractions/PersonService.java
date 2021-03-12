package it.bit.academy.corsopiu.services.abstractions;

import it.bit.academy.corsopiu.entities.Person;

import java.util.Collection;
import java.util.Optional;

public interface PersonService {
    Collection<Person> getPersons();

    Person savePerson(Person person);

    Optional<Person> getPersonById(long id);

    void deletePerson(long id);
}
