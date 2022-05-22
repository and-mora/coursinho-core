package it.amorabito.coursinho.controllers;

import it.amorabito.coursinho.model.dtos.CourseDto;
import it.amorabito.coursinho.model.dtos.CourseEditionPresentation;
import it.amorabito.coursinho.model.dtos.CourseFilter;
import it.amorabito.coursinho.model.mapper.CourseMapper;
import it.amorabito.coursinho.services.abstractions.CourseEditionService;
import it.amorabito.coursinho.services.abstractions.CourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/course")
@CrossOrigin
@RequiredArgsConstructor
@Slf4j
public class CourseController {

    private final CourseService courseService;
    private final CourseEditionService courseEditionService;
    private final CourseMapper courseMapper;

    /**
     * Get a collection of courses
     *
     * @return
     */
    @GetMapping("/")
    public ResponseEntity<Collection<CourseDto>> getAllCourses() {
        log.info("allCourses");
        Collection<CourseDto> courses = courseService.getCourses();

        return ResponseEntity.ok(courses);
    }

    /**
     * Get courses with edition and filter on price if priceRange is present
     *
     * @param filter
     * @return
     */
    @PostMapping("/search")
    public ResponseEntity<Collection<CourseEditionPresentation>> getFilteredCoursesWithMostRecentEdition(
            @RequestBody CourseFilter filter) {
        log.info("getFilteredCoursesWithMostRecentEdition");
        var results = courseService.getFilteredCoursesWithMostRecentEdition(filter);

        return ResponseEntity.ok(results);
    }

    /**
     * Get only one course
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<CourseDto> findCourseById(@PathVariable long id) {
        log.info("findCourseById");
        var course = courseService.getCourseById(id);

        return ResponseEntity.ok(course);
    }

    /**
     * Delete a course
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<CourseDto> deleteCourseById(@PathVariable long id) {
        log.info("deleteCourseById");

        var course = courseService.getCourseById(id);

        courseService.deleteCourse(id);
        return ResponseEntity.ok(course);
    }

    /**
     * Create a new course
     *
     * @param courseDto
     * @return
     */
    @PostMapping("/")
    public ResponseEntity<CourseDto> createCourse(@RequestBody CourseDto courseDto) {
        log.info("createCourse");
        var saved = courseService.saveCourse(courseDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    /**
     * Update course
     *
     * @param courseDto
     * @return dto course update
     */
    @PutMapping("/")
    public ResponseEntity<CourseDto> updateCourse(@RequestBody CourseDto courseDto) {
        log.info("updateCourse");
        var saved = courseService.updateCourse(courseDto);

        return ResponseEntity.ok(saved);
    }
}
