package it.amorabito.coursinho.repositories;

import it.amorabito.coursinho.model.entities.Course;
import it.amorabito.coursinho.model.entities.CourseEdition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

public interface CourseEditionRepository extends JpaRepository<CourseEdition, Long> {
//    @Query("select ce from CourseEdition as ce where ce.course.id = :courseId")
//    Collection<CourseEdition> getAllCoursesEditionsByIdCourseQuery(@Param("courseId") Long courseId);

    Collection<CourseEdition> findByCourse(Course course);

    Optional<CourseEdition> findFirstByCourseOrderByStartDateDesc(Course course);

}
