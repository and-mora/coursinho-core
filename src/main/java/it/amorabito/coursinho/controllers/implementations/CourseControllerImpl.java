package it.amorabito.coursinho.controllers.implementations;

import it.amorabito.coursinho.controllers.CourseController;
import it.amorabito.coursinho.model.dtos.CourseDto;
import it.amorabito.coursinho.model.dtos.CourseEditionPresentation;
import it.amorabito.coursinho.model.dtos.CourseFilter;
import it.amorabito.coursinho.services.abstractions.CourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@Slf4j
public class CourseControllerImpl implements CourseController {

    private final CourseService courseService;


    @Override
    public ResponseEntity<Collection<CourseDto>> getAllCourses() {
        log.info("allCourses");
        Collection<CourseDto> courses = courseService.getCourses();

        return ResponseEntity.ok(courses);
    }

    @Override
    public ResponseEntity<Collection<CourseEditionPresentation>> getFilteredCoursesWithMostRecentEdition(
            @RequestBody CourseFilter filter) {
        log.info("getFilteredCoursesWithMostRecentEdition");
        var results = courseService.getFilteredCoursesWithMostRecentEdition(filter);

        return ResponseEntity.ok(results);
    }

    @Override
    public Collection<CourseDto> getFiltered(CourseFilter courseFilter) {
        log.info("getFilteredCourses");
        return courseService.getFiltered(courseFilter);
    }

    @Override
    public ResponseEntity<CourseDto> findCourseById(@PathVariable long id) {
        log.info("findCourseById");
        var course = courseService.getCourseById(id);

        return ResponseEntity.ok(course);
    }

    @Override
    public ResponseEntity<CourseDto> deleteCourseById(@PathVariable long id) {
        log.info("deleteCourseById");

        var course = courseService.getCourseById(id);

        courseService.deleteCourse(id);
        return ResponseEntity.ok(course);
    }

    @Override
    public ResponseEntity<CourseDto> createCourse(@RequestBody CourseDto courseDto) {
        log.info("createCourse");
        var saved = courseService.saveCourse(courseDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @Override
    public ResponseEntity<CourseDto> updateCourse(@RequestBody CourseDto courseDto) {
        log.info("updateCourse");
        var saved = courseService.updateCourse(courseDto);

        return ResponseEntity.ok(saved);
    }
}
