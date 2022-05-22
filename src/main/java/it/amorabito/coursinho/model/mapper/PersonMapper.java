package it.amorabito.coursinho.model.mapper;

import it.amorabito.coursinho.model.dtos.PersonDto;
import it.amorabito.coursinho.model.entities.Employee;
import it.amorabito.coursinho.model.entities.Person;
import it.amorabito.coursinho.model.entities.Student;
import it.amorabito.coursinho.model.entities.Teacher;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonDto toDto(Person person);

    Collection<PersonDto> toDtoList(Collection<Person> persons);

    PersonDto fromTeacherToDto(Teacher teacher);

    Collection<PersonDto> fromTeacherToDtoList(Collection<Teacher> teacher);

    PersonDto fromStudentToDto(Student student);

    Collection<PersonDto> fromStudentToDtoList(Collection<Student> student);

    PersonDto fromEmployeeToDto(Employee employee);

    Collection<PersonDto> fromEmployeeToDtoList(Collection<Employee> employee);
}
