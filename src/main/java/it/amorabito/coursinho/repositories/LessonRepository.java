package it.amorabito.coursinho.repositories;

import it.amorabito.coursinho.entities.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
