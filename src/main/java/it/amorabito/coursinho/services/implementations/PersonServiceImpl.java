package it.amorabito.coursinho.services.implementations;

import it.amorabito.coursinho.entities.Employee;
import it.amorabito.coursinho.entities.Person;
import it.amorabito.coursinho.entities.Student;
import it.amorabito.coursinho.entities.Teacher;
import it.amorabito.coursinho.repositories.EmployeeRepository;
import it.amorabito.coursinho.repositories.PersonRepository;
import it.amorabito.coursinho.repositories.StudentRepository;
import it.amorabito.coursinho.repositories.TeacherRepository;
import it.amorabito.coursinho.services.abstractions.PersonService;
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
