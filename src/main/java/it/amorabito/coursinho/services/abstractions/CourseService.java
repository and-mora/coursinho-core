package it.amorabito.coursinho.services.abstractions;

import it.amorabito.coursinho.model.dtos.CategoryData;
import it.amorabito.coursinho.model.dtos.CourseDto;
import it.amorabito.coursinho.model.dtos.CourseEditionPresentation;
import it.amorabito.coursinho.model.dtos.CourseFilter;

import java.util.Collection;

public interface CourseService {

    Collection<CourseDto> getCourses();

    Collection<CategoryData> getCategoriesCount();

    Double getCourseMaxPrice();

    Double getCourseMinPrice();

    CourseDto getCourseById(long id);

    Collection<CourseDto> getCoursesByCategoryLike(String categoryLike);

    Collection<CourseDto> getCoursesWithEditions();

    void deleteCourse(long id);

    CourseDto saveCourse(CourseDto course);

    CourseDto updateCourse(CourseDto courseDto);

    Collection<CourseEditionPresentation> getFilteredCoursesWithMostRecentEdition(CourseFilter filter);
}