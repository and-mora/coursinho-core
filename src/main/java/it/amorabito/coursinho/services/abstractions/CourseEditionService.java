package it.amorabito.coursinho.services.abstractions;

import it.amorabito.coursinho.exceptions.EntityNotFoundException;
import it.amorabito.coursinho.model.dtos.CourseDto;
import it.amorabito.coursinho.model.dtos.CourseEditionDto;
import it.amorabito.coursinho.model.dtos.ModuleDto;
import it.amorabito.coursinho.model.dtos.WeeklySessionDto;

import java.util.Collection;

public interface CourseEditionService {

    CourseEditionDto getCourseEditionById(long id);

    Collection<ModuleDto> getModuleByCourseEditionId(long id);

    Collection<CourseEditionDto> getByCourse(long id) throws EntityNotFoundException;

    Collection<CourseEditionDto> getAllCoursesEditions();

    CourseEditionDto getFirstByCourseOrderByStartDateDesc(CourseDto course);

    CourseEditionDto createCourseEdition(CourseEditionDto courseEdition) throws EntityNotFoundException;

    ModuleDto createModule(ModuleDto module) throws EntityNotFoundException;

    WeeklySessionDto createWeeklySession(WeeklySessionDto weeklySession) throws EntityNotFoundException;

    void deleteCourseEdition(long id);

    Collection<CourseDto> getMostRecentEdition(Collection<CourseDto> filteredCourses);
}
