package it.bit.academy.corsopiu.services.implementations;

import it.bit.academy.corsopiu.entities.Person;
import it.bit.academy.corsopiu.repositories.PersonRepository;
import it.bit.academy.corsopiu.services.abstractions.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

@Service
@Transactional
public class PersonImpl implements PersonService {

    PersonRepository personRepository;

    @Autowired
    PersonImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Collection<Person> getPersons() {
        return personRepository.findAll();
    }

    @Override
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Optional<Person> getPersonById(long id) {
        return this.personRepository.findById(id);
    }

    @Override
    public void deletePerson(long id) {
        this.personRepository.deleteById(id);
    }


}
