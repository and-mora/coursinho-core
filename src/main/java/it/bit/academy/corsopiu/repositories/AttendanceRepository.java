package it.bit.academy.corsopiu.repositories;

import it.bit.academy.corsopiu.entities.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
}
