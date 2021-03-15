package it.bit.academy.corsopiu.repositories;

import it.bit.academy.corsopiu.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Collection<Student> findTop10ByFirstNameContainsIgnoreCaseOrLastNameContainsIgnoreCaseOrFiscalCodeContainsIgnoreCase(String firstName, String lastName, String fiscalCode);
}
