package it.bit.academy.corsopiu.repositories;

import it.bit.academy.corsopiu.entities.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
}
