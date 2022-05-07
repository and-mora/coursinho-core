package it.amorabito.coursinho.repositories;

import it.amorabito.coursinho.model.entities.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
}
