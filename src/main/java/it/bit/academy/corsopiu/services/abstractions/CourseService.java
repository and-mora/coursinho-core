package it.bit.academy.corsopiu.services.abstractions;

import it.bit.academy.corsopiu.dtos.CategoryData;
import it.bit.academy.corsopiu.dtos.Paginator;
import it.bit.academy.corsopiu.entities.Course;
import org.springframework.data.domain.Page;

import java.util.Collection;
import java.util.Optional;

public interface CourseService {

    Collection<Course> getCourses();

    Collection<CategoryData> getCategoriesCount();

    Double getCourseMaxPrice();

    Double getCourseMinPrice();

    Optional<Course> getCourseById(long id);

    Page<Collection<Course>> getCoursesByCategoryLikePaged(String categoryLike, Paginator pg);

    Collection<Course> getCoursesByCategoryLike(String categoryLike);

    Collection<Course> getCoursesBetweenPrices(double minPrice, double maxPrice);

    Collection<Course> getCoursesWithEditions();

    void deleteCourse(long id);

    Course saveCourse(Course course);


}