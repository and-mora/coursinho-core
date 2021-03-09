package it.bit.academy.corsopiu.repositories;

import it.bit.academy.corsopiu.entities.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
}
