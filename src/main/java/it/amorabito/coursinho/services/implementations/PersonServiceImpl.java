package it.amorabito.coursinho.services.implementations;

import it.amorabito.coursinho.model.dtos.PersonDto;
import it.amorabito.coursinho.model.mapper.PersonMapper;
import it.amorabito.coursinho.repositories.EmployeeRepository;
import it.amorabito.coursinho.repositories.PersonRepository;
import it.amorabito.coursinho.repositories.StudentRepository;
import it.amorabito.coursinho.repositories.TeacherRepository;
import it.amorabito.coursinho.services.abstractions.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Transactional
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepo;
    private final TeacherRepository teacherRepo;
    private final EmployeeRepository employeeRepo;
    private final StudentRepository studentRepo;
    private final PersonMapper personMapper;

    @Override
    public Collection<PersonDto> getPersons() {
        return personMapper.toDtoList(personRepo.findAll());
    }

//    @Override
//    public PersonDto savePerson(PersonDto person) {
//        return personMapper.toDto(personRepo.save(personMapper.toEntity(person)));
//    }

    @Override
    public PersonDto getPersonById(long id) {
        return personMapper.toDto(personRepo.findById(id).orElseThrow());
    }

    @Override
    public Collection<PersonDto> getTeachers() {
        return personMapper.fromTeacherToDtoList(teacherRepo.findAll());
    }

    @Override
    public Collection<PersonDto> getEmployees() {
        return personMapper.fromEmployeeToDtoList(employeeRepo.findAll());
    }

    @Override
    public Collection<PersonDto> getStudents() {
        return personMapper.fromStudentToDtoList(studentRepo.findAll());
    }

    @Override
    public Collection<PersonDto> getStudentsContaining(String firstName, String lastName, String fiscalCode) {
        return personMapper.fromStudentToDtoList(studentRepo.findTop10ByFirstNameContainsIgnoreCaseOrLastNameContainsIgnoreCaseOrFiscalCodeContainsIgnoreCase(firstName, lastName, fiscalCode));
    }

    @Override
    public void deletePerson(long id) {
        personRepo.deleteById(id);
    }


}
