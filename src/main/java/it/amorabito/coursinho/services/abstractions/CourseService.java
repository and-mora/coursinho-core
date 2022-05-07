package it.amorabito.coursinho.services.abstractions;

import it.amorabito.coursinho.model.dtos.CategoryData;
import it.amorabito.coursinho.model.entities.Course;

import java.util.Collection;
import java.util.Optional;

public interface CourseService {

    Collection<Course> getCourses();

    Collection<CategoryData> getCategoriesCount();

    Double getCourseMaxPrice();

    Double getCourseMinPrice();

    Optional<Course> getCourseById(long id);

//    Page<Collection<Course>> getCoursesByCategoryLikePaged(String categoryLike, Paginator pg);

    Collection<Course> getCoursesByCategoryLike(String categoryLike);

//    Collection<Course> getCoursesBetweenPrices(double minPrice, double maxPrice);

    Collection<Course> getCoursesWithEditions();

    Collection<Course> getCoursesWithEditionsByPrice(double minPrice, double maxPrice);

    void deleteCourse(long id);

    Course saveCourse(Course course);


}