package it.amorabito.coursinho.services.abstractions;

import it.amorabito.coursinho.exceptions.EntityNotFoundException;
import it.amorabito.coursinho.model.entities.Course;
import it.amorabito.coursinho.model.entities.CourseEdition;
import it.amorabito.coursinho.model.entities.Module;
import it.amorabito.coursinho.model.entities.WeeklySession;

import java.util.Collection;
import java.util.Optional;

public interface CourseEditionService {

    Optional<CourseEdition> getCourseEditionById(long id);

    Collection<Module> getModuleByCourseEditionId(long id);

    Collection<CourseEdition> getByCourse(long id) throws EntityNotFoundException;

    Collection<CourseEdition> getAllCoursesEditions();

    Optional<CourseEdition> getFirstByCourseOrderByStartDateDesc(Course course);

    CourseEdition createCourseEdition(CourseEdition courseEdition) throws EntityNotFoundException;

    Module createModule(Module module) throws EntityNotFoundException;

    WeeklySession createWeeklySession(WeeklySession weeklySession) throws EntityNotFoundException;

    void deleteCourseEdition(long id);

}
