package it.amorabito.coursinho.services.abstractions;

import it.amorabito.coursinho.model.entities.Employee;
import it.amorabito.coursinho.model.entities.Person;
import it.amorabito.coursinho.model.entities.Student;
import it.amorabito.coursinho.model.entities.Teacher;

import java.util.Collection;
import java.util.Optional;

public interface PersonService {
    Collection<Person> getPersons();

    Person savePerson(Person person);

    Optional<Person> getPersonById(long id);

    Collection<Teacher> getTeachers();

    Collection<Employee> getEmployees();

    Collection<Student> getStudents();

    Collection<Student> getStudentsContaining(String firstName, String lastName, String fiscalCode);

    void deletePerson(long id);
}
