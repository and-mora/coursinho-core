package it.amorabito.coursinho.repositories;

import it.amorabito.coursinho.model.entities.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
}
