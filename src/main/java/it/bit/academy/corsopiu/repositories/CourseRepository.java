package it.bit.academy.corsopiu.repositories;

import it.bit.academy.corsopiu.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
