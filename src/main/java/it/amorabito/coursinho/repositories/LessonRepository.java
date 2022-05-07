package it.amorabito.coursinho.repositories;

import it.amorabito.coursinho.model.entities.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
