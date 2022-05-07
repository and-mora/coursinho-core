package it.amorabito.coursinho.model.dtos;

import it.amorabito.coursinho.model.entities.*;

import java.time.LocalDate;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getFiscalCode() {
        return fiscalCode;
    }

    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public PersonType getPersonType() {
        return personType;
    }

    public void setPersonType(PersonType personType) {
        this.personType = personType;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }
}
