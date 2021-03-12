package it.bit.academy.corsopiu.services.abstractions;

import it.bit.academy.corsopiu.entities.Employee;
import it.bit.academy.corsopiu.entities.Person;
import it.bit.academy.corsopiu.entities.Student;
import it.bit.academy.corsopiu.entities.Teacher;
import it.bit.academy.corsopiu.repositories.EmployeeRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface PersonService {
    Collection<Person> getPersons();

    Person savePerson(Person person);

    Optional<Person> getPersonById(long id);

    Collection<Teacher> getTeachers();

    Collection<Employee> getEmployees();

    Collection<Student> getStudents();

    void deletePerson(long id);
}
