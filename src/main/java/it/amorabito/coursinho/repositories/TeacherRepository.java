package it.amorabito.coursinho.repositories;

import it.amorabito.coursinho.model.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
