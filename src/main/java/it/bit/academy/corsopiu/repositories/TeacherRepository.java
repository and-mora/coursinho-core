package it.bit.academy.corsopiu.repositories;

import it.bit.academy.corsopiu.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
