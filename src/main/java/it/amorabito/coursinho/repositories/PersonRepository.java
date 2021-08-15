package it.amorabito.coursinho.repositories;

import it.amorabito.coursinho.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonRepository extends JpaRepository<Person, Long> {
   
}
