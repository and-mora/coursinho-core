package it.bit.academy.corsopiu.repositories;

import it.bit.academy.corsopiu.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
