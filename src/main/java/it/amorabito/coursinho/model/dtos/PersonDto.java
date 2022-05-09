package it.amorabito.coursinho.model.dtos;

import it.amorabito.coursinho.model.entities.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PersonDto {

    public PersonDto(){
    }

    public PersonDto(Person p){
        this.id = p.getId();
        this.firstName = p.getFirstName();
        this.lastName = p.getLastName();
        this.gender = p.getGender();
        this.email = p.getEmail();
        this.phone = p.getPhone();
        this.birthDate = p.getBirthDate();
        this.birthPlace = p.getBirthPlace();
        this.fiscalCode = p.getFiscalCode();
        this.address = p.getAddress();

        if (p instanceof Employee){
            Employee pt = (Employee) p;
            this.personType = PersonType.EMPL;
            this.role = pt.getRole();
            this.salary = pt.getSalary();
        }else if(p instanceof Student){
            Student st = (Student) p;
            this.personType = PersonType.STUD;
        }else{
            Teacher th = (Teacher) p;
            this.personType = PersonType.TEACH;
            this.hourlyWage = th.getHourlyWage();
        }
    }

    public Person toPerson(){
        Person person = null;
        switch (this.getPersonType()){
            case EMPL:
                person = new Employee();
                Employee empl = (Employee) person;
                empl.setRole(this.getRole());
                empl.setSalary(this.getSalary());
                break;
            case STUD:
                person = new Student();
                Student stud = (Student) person;
                break;
            case TEACH:
                person = new Teacher();
                Teacher tch = (Teacher) person;
                tch.setHourlyWage(this.getHourlyWage());
                break;
            default:
                break;
        }
        person.setId(this.getId());
        person.setFirstName(this.getFirstName());
        person.setLastName(this.getLastName());
        person.setGender(this.getGender());
        person.setEmail(this.getEmail());
        person.setPhone(this.getPhone());
        person.setBirthDate(this.getBirthDate());
        person.setBirthPlace(this.getBirthPlace());
        person.setFiscalCode(this.getFiscalCode());
        person.setAddress(this.getAddress());

        return person;
    }

    private long id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private String email;
    private String phone;
    private LocalDate birthDate;
    private String birthPlace;
    private String fiscalCode;
    private Address address;
    private PersonType personType;
    private String role;
    private double salary;
    private double hourlyWage;
}
