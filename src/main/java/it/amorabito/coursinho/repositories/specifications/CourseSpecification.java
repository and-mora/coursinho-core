package it.amorabito.coursinho.repositories.specifications;


import it.amorabito.coursinho.model.dtos.CourseFilter;
import it.amorabito.coursinho.model.entities.Course;
import it.amorabito.coursinho.model.entities.Course_;
import org.springframework.data.jpa.domain.Specification;

public class CourseSpecification {

    private CourseSpecification() {
    }

    public static Specification<Course> hasPriceLowerThan(Double priceMax) {
        return (root, query, criteriaBuilder) -> priceMax == null ?
                criteriaBuilder.isTrue(criteriaBuilder.literal(true)) :
                criteriaBuilder.lessThanOrEqualTo(root.get(Course_.price), priceMax);
    }

    public static Specification<Course> hasPriceGreaterThan(Double priceMin) {
        return (root, query, criteriaBuilder) -> priceMin == null ?
                criteriaBuilder.isTrue(criteriaBuilder.literal(true)) :
                criteriaBuilder.greaterThanOrEqualTo(root.get(Course_.price), priceMin);
    }

    public static Specification<Course> hasCategoryLike(String category) {
        return (root, query, criteriaBuilder) -> category == null ?
                criteriaBuilder.isTrue(criteriaBuilder.literal(true)) :
                criteriaBuilder.like(root.get(Course_.category), category);
    }

    public static Specification<Course> getCourseFilterConditions(CourseFilter courseFilter) {
        return Specification.where(hasCategoryLike(courseFilter.getCategory())
                .and(hasPriceGreaterThan(courseFilter.getMinimumPrice()))
                .and(hasPriceLowerThan(courseFilter.getMaximumPrice())));
    }
}
