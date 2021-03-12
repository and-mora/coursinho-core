package it.bit.academy.corsopiu.repositories;

import it.bit.academy.corsopiu.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
