package it.amorabito.coursinho.repositories;

import it.amorabito.coursinho.model.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Collection<Student> findTop10ByFirstNameContainsIgnoreCaseOrLastNameContainsIgnoreCaseOrFiscalCodeContainsIgnoreCase(String firstName, String lastName, String fiscalCode);
}
