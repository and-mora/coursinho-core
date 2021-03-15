package it.bit.academy.corsopiu.services.implementations;

import it.bit.academy.corsopiu.entities.Employee;
import it.bit.academy.corsopiu.entities.Person;
import it.bit.academy.corsopiu.entities.Student;
import it.bit.academy.corsopiu.entities.Teacher;
import it.bit.academy.corsopiu.repositories.EmployeeRepository;
import it.bit.academy.corsopiu.repositories.PersonRepository;
import it.bit.academy.corsopiu.repositories.StudentRepository;
import it.bit.academy.corsopiu.repositories.TeacherRepository;
import it.bit.academy.corsopiu.services.abstractions.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepo;
    private TeacherRepository teacherRepo;
    private EmployeeRepository employeeRepo;
    private StudentRepository studentRepo;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository,
                             TeacherRepository teacherRepo,
                             EmployeeRepository employeeRepo,
                             StudentRepository studentRepo) {
        this.personRepo = personRepository;
        this.teacherRepo = teacherRepo;
        this.employeeRepo = employeeRepo;
        this.studentRepo = studentRepo;
    }

    @Override
    public Collection<Person> getPersons() {
        return personRepo.findAll();
    }

    @Override
    public Person savePerson(Person person) {
        return personRepo.save(person);
    }

    @Override
    public Optional<Person> getPersonById(long id) {
        return this.personRepo.findById(id);
    }

    @Override
    public Collection<Teacher> getTeachers() {
        return this.teacherRepo.findAll();
    }

    @Override
    public Collection<Employee> getEmployees() {
        return this.employeeRepo.findAll();
    }

    @Override
    public Collection<Student> getStudents() {
        return this.studentRepo.findAll();
    }

    @Override
    public Collection<Student> getStudentsContaining(String firstName, String lastName, String fiscalCode) {
        return this.studentRepo.findTop10ByFirstNameContainsIgnoreCaseOrLastNameContainsIgnoreCaseOrFiscalCodeContainsIgnoreCase(firstName, lastName, fiscalCode);
    }

    @Override
    public void deletePerson(long id) {
        this.personRepo.deleteById(id);
    }


}
