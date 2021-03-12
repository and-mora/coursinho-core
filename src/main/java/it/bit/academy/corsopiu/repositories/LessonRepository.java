package it.bit.academy.corsopiu.repositories;

import it.bit.academy.corsopiu.entities.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
