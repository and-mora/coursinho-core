package it.bit.academy.corsopiu.repositories;

import it.bit.academy.corsopiu.entities.WeeklySession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeeklySessionRepository extends JpaRepository<WeeklySession, Long> {
}
