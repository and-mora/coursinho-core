package it.amorabito.coursinho.repositories.custom;

import it.amorabito.coursinho.model.dtos.CourseFilter;
import it.amorabito.coursinho.model.entities.Course;
import it.amorabito.coursinho.repositories.CourseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CourseRepositoryCustomImplTest {

    @Autowired
    private CourseRepository courseRepository;

    @BeforeEach
    void setup() {
        courseRepository.save(createCourse(1, "firstCourse", 100.0));
        courseRepository.save(createCourse(2, "secondCourse", 50.0));
    }

    @Test
    void whenSetMinimumPriceThenReturnsCoursesWithHigherPrice() {
        CourseFilter filters = new CourseFilter();
        filters.setMinimumPrice(60.0);

        Collection<Course> courses = courseRepository.findFiltered(filters);

        assertThat(courses).isNotEmpty().hasSize(1);
        assertThat(courses.stream().findAny().get()).extracting("name").isEqualTo("firstCourse");
    }

    @Test
    void whenSetPriceRangeThenReturnsCoursesInRangeIfAny() {
        CourseFilter filters = new CourseFilter();
        filters.setMinimumPrice(45.0);
        filters.setMaximumPrice(46.0);

        Collection<Course> courses = courseRepository.findFiltered(filters);

        assertThat(courses).isEmpty();
    }

    @Test
    void whenSetMaximumPriceThenReturnsCoursesWithLowerPrice() {
        CourseFilter filters = new CourseFilter();
        filters.setMaximumPrice(110.0);

        Collection<Course> courses = courseRepository.findFiltered(filters);

        assertThat(courses).isNotEmpty().hasSize(2);
    }

    @Test
    void whenSetMaximumPriceThenReturnsCoursesWithEqualPrice() {
        CourseFilter filters = new CourseFilter();
        filters.setMaximumPrice(100.0);

        Collection<Course> courses = courseRepository.findFiltered(filters);

        assertThat(courses).isNotEmpty().hasSize(2);
        assertThat(courses.stream().findAny().get()).extracting("price").isEqualTo(100.0);
    }

    @Test
    void whenSetEqualPriceRangeThenReturnsCoursesWithEqualPrice() {
        CourseFilter filters = new CourseFilter();
        filters.setMinimumPrice(100.0);
        filters.setMaximumPrice(100.0);

        Collection<Course> courses = courseRepository.findFiltered(filters);

        assertThat(courses).isNotEmpty().hasSize(1);
        assertThat(courses.stream().findAny().get()).extracting("price").isEqualTo(100.0);
    }

    @Test
    void whenCourseFilterIsNullThenReturnsAllCourses() {
        Collection<Course> courses = courseRepository.findFiltered(null);

        assertThat(courses).isNotEmpty().hasSize(2);
    }

    Course createCourse(long id, String name, double price) {
        Course course = new Course();
        course.setId(id);
        course.setName(name);
        course.setPrice(price);
        return course;
    }
}