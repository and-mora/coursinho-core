package it.bit.academy.corsopiu.controllers;

import it.bit.academy.corsopiu.dtos.PersonDto;
import it.bit.academy.corsopiu.entities.Person;
import it.bit.academy.corsopiu.services.abstractions.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/person")
@CrossOrigin
public class PersonController {


    private PersonService personService;

    @Autowired
    PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDto> findPersonById(@PathVariable long id) {
        Optional<Person> opt = personService.getPersonById(id);
        if (opt.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(new PersonDto(opt.get()), HttpStatus.OK);
    }


    /**
     * Gets all the person
     *
     * @return
     */
    @GetMapping("/")
    public ResponseEntity<Collection<PersonDto>> getAllPerson() {
        Collection<Person> listPerson = personService.getPersons();
        List<PersonDto> result = listPerson.stream().map(PersonDto::new).collect(Collectors.toList());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{value}")
    public ResponseEntity<Collection<PersonDto>> getPersonsByType(@PathVariable String value) {

        switch (value) {
            case "teachers":
                return new ResponseEntity<>(personService.getTeachers().stream().map(PersonDto::new).collect(Collectors.toList()), HttpStatus.OK);
            case "students":
                return new ResponseEntity<>(personService.getStudents().stream().map(PersonDto::new).collect(Collectors.toList()), HttpStatus.OK);
            case "employees":
                return new ResponseEntity<>(personService.getEmployees().stream().map(PersonDto::new).collect(Collectors.toList()), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    /**
     * Create a new person
     *
     * @return
     */
    @PostMapping("/")
    public ResponseEntity<PersonDto> createPerson(@RequestBody PersonDto personDto) {

        Person person = personDto.toPerson();
        Person saved = personService.savePerson(person);
        PersonDto saveDto = new PersonDto((saved));
        return new ResponseEntity<>(saveDto, HttpStatus.OK);
    }

    /**
     * Delete person
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<PersonDto> deletePerson(@PathVariable long id) {
        Optional<Person> opt = personService.getPersonById(id);
        if (opt.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        personService.deletePerson(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
