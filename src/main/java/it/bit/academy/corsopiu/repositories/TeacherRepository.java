package it.bit.academy.corsopiu.repositories;

import it.bit.academy.corsopiu.entities.Person;
import it.bit.academy.corsopiu.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
//    @Query("select p from Person as p where p.person_type = 'EMPL'")
//    Collection<Teacher> getAllEmployee();
}
