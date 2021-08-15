package it.amorabito.coursinho.repositories;

import it.amorabito.coursinho.entities.Course;
import it.amorabito.coursinho.entities.CourseEdition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.Optional;

public interface CourseEditionRepository extends JpaRepository<CourseEdition, Long> {
//    @Query("select ce from CourseEdition as ce where ce.course.id = :courseId")
//    Collection<CourseEdition> getAllCoursesEditionsByIdCourseQuery(@Param("courseId") Long courseId);

    Collection<CourseEdition> findByCourse(Course course);

    Optional<CourseEdition> findFirstByCourseOrderByStartDateDesc(Course course);

}
