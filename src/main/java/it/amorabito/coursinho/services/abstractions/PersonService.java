package it.amorabito.coursinho.services.abstractions;

import it.amorabito.coursinho.entities.Employee;
import it.amorabito.coursinho.entities.Person;
import it.amorabito.coursinho.entities.Student;
import it.amorabito.coursinho.entities.Teacher;

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
