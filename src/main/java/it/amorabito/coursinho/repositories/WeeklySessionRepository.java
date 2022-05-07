package it.amorabito.coursinho.repositories;

import it.amorabito.coursinho.model.entities.WeeklySession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeeklySessionRepository extends JpaRepository<WeeklySession, Long> {
}
