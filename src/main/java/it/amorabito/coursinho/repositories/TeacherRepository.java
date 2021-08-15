package it.amorabito.coursinho.repositories;

import it.amorabito.coursinho.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
