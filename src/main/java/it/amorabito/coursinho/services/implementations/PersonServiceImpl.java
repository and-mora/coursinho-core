package it.amorabito.coursinho.services.implementations;

import it.amorabito.coursinho.model.entities.Employee;
import it.amorabito.coursinho.model.entities.Person;
import it.amorabito.coursinho.model.entities.Student;
import it.amorabito.coursinho.model.entities.Teacher;
import it.amorabito.coursinho.repositories.EmployeeRepository;
import it.amorabito.coursinho.repositories.PersonRepository;
import it.amorabito.coursinho.repositories.StudentRepository;
import it.amorabito.coursinho.repositories.TeacherRepository;
import it.amorabito.coursinho.services.abstractions.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepo;
    private final TeacherRepository teacherRepo;
    private final EmployeeRepository employeeRepo;
    private final StudentRepository studentRepo;

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
