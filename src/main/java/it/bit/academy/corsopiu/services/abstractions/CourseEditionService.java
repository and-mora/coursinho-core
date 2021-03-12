package it.bit.academy.corsopiu.services.abstractions;

import it.bit.academy.corsopiu.entities.Course;
import it.bit.academy.corsopiu.entities.CourseEdition;
import it.bit.academy.corsopiu.entities.Module;
import it.bit.academy.corsopiu.exceptions.EntityNotFoundException;

import java.util.Collection;
import java.util.Optional;

public interface CourseEditionService {

    Optional<CourseEdition> getCourseEditionById(long id);

    Collection<Module> getModuleByCourseEditionId(long id);

    CourseEdition createCourseEdition(CourseEdition courseEdition) throws EntityNotFoundException;

    Collection<CourseEdition> getByCourse(long id) throws EntityNotFoundException;

    Collection<CourseEdition> getAllCoursesEditions();

    Optional<CourseEdition> getFirstByCourseOrderByStartDateDesc(Course course);

    void deleteCourseEdition(long id);

}
