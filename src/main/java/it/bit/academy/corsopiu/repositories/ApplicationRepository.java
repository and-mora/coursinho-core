package it.bit.academy.corsopiu.repositories;

import it.bit.academy.corsopiu.entities.Application;
import it.bit.academy.corsopiu.entities.CourseEdition;
import it.bit.academy.corsopiu.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

//    @Query("select app from Application app where app.edition = :editionId")
    Collection<Application> findByEdition(CourseEdition courseEdition);

    Collection<Application> findByStudent(Student student);
}
