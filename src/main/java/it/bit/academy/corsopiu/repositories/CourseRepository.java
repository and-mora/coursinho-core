package it.bit.academy.corsopiu.repositories;

import it.bit.academy.corsopiu.entities.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {
}
