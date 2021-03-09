package it.bit.academy.corsopiu.services.abstractions;

import it.bit.academy.corsopiu.dtos.CategoryData;
import it.bit.academy.corsopiu.entities.Course;

import java.util.Collection;
import java.util.Optional;

public interface CourseService {

    Collection<Course> getCourses();

    Collection<CategoryData> getCategoriesCount();

    Optional<Course> getCourseById(long id);

    void deleteCourse(long id);

    Course saveCourse(Course course);


}