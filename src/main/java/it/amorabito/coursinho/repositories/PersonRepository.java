package it.amorabito.coursinho.repositories;

import it.amorabito.coursinho.model.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
   
}
