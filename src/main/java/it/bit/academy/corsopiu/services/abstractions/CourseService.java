package it.bit.academy.corsopiu.services.abstractions;

import it.bit.academy.corsopiu.entities.Course;

import java.util.Collection;
import java.util.Optional;

public interface CourseService {

    Collection<Course> getCourses();

    Collection<String> getAllCategories();

    Optional<Course> getCourseById(long id);

}