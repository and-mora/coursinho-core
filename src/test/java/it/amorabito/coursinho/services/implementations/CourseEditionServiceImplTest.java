package it.amorabito.coursinho.services.implementations;

import it.amorabito.coursinho.model.dtos.CourseDto;
import it.amorabito.coursinho.model.dtos.CourseEditionDto;
import it.amorabito.coursinho.services.abstractions.CourseEditionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CourseEditionServiceImplTest {

//    private static AutoCloseable autoCloseable;

    CourseEditionServiceImplTest() {
//        autoCloseable = MockitoAnnotations.openMocks(this);
    }

    CourseEditionService courseEditionService = new CourseEditionServiceImpl(null,
            null, null, null, null, null, null,
            null, null, null);

    List<CourseDto> courseDtoList;

    @BeforeEach
    void init() {
        courseDtoList = new ArrayList<>();
        courseDtoList.add(createCourse(0L, "cucina"));
        courseDtoList.add(createCourse(1L, "giardinaggio"));
    }

    @Test
    void givenCourseWithTwoEditionsGetTheMostRecent() {
        var courseWithMostRecentEdition = courseEditionService.getMostRecentEdition(courseDtoList);

        var editions = courseWithMostRecentEdition.stream().findAny().orElseThrow().getEditions();
        assertThat(courseWithMostRecentEdition).isNotEmpty();
        assertThat(editions.get(0))
                .extracting("startDate").isEqualTo(LocalDate.now().minusMonths(1));
    }

    @Test
    void givenCourseWithOneEditionGetTheOnlyOne() {
        CourseDto course = new CourseDto();
        course.setEditions(List.of(
                createCourseEdition(1L, "first edition", LocalDate.now().minusMonths(2))));

        var courseWithMostRecentEdition = courseEditionService.getMostRecentEdition(List.of(course));

        var editions = courseWithMostRecentEdition.stream().findAny().orElseThrow().getEditions();
        assertThat(courseWithMostRecentEdition).isNotEmpty();
        assertThat(editions).hasSize(1);
        assertThat(editions.get(0))
                .extracting("startDate").isEqualTo(LocalDate.now().minusMonths(2));
    }

    @Test
    void givenCourseWithNoEditionsGetEmptyList() {
        CourseDto course = new CourseDto();
        course.setEditions(Collections.emptyList());

        var courseWithMostRecentEdition = courseEditionService.getMostRecentEdition(List.of(course));
        var editions = courseWithMostRecentEdition.stream().findAny().orElseThrow().getEditions();

        assertThat(courseWithMostRecentEdition).isNotEmpty();
        assertThat(editions).isEmpty();
    }

    CourseDto createCourse(long id, String category) {
        CourseDto course = new CourseDto();
        course.setEditions(Arrays.asList(
                createCourseEdition(1L, "first edition", LocalDate.now().minusMonths(2)),
                createCourseEdition(2L, "second edition", LocalDate.now().minusMonths(1))));
        course.setId(id);
        course.setCategory(category);

        return course;
    }

    CourseEditionDto createCourseEdition(long id, String description, LocalDate startDate) {
        CourseEditionDto courseEdition = new CourseEditionDto();
        courseEdition.setId(id);
        courseEdition.setDescription(description);
        courseEdition.setStartDate(startDate);

        return courseEdition;
    }

//    @AfterAll
//    static void cleanup() throws Exception {
//        autoCloseable.close();
//    }
}