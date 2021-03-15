package it.bit.academy.corsopiu.repositories;

import it.bit.academy.corsopiu.entities.Application;
import it.bit.academy.corsopiu.entities.CourseEdition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

//    @Query("select app from Application app where app.edition = :editionId")
    Collection<Application> findByEdition(CourseEdition courseEdition);
}
