package it.amorabito.coursinho.controllers;

import it.amorabito.coursinho.model.dtos.CourseDto;
import it.amorabito.coursinho.model.dtos.CourseEditionPresentation;
import it.amorabito.coursinho.model.dtos.CourseFilter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequestMapping("/api/course")
public interface CourseController {

    /**
     * Rest api to retrieve all the course.
     *
     * @return a collection of courses
     */
    @GetMapping("/")
    ResponseEntity<Collection<CourseDto>> getAllCourses();

    /**
     * Retrieve filtered courses.
     *
     * @param filter filter to apply
     * @return a collection of courses
     */
    @PostMapping("/search")
    ResponseEntity<Collection<CourseEditionPresentation>> getFilteredCoursesWithMostRecentEdition(
            @RequestBody CourseFilter filter);

    /**
     * Retrieve the course identified by id.
     *
     * @param id unique identifier of a course
     * @return a course
     */
    @GetMapping("/{id}")
    ResponseEntity<CourseDto> findCourseById(@PathVariable long id);

    /**
     * Delete a course identified by id.
     *
     * @param id unique identifier of a course
     * @return the course deleted
     */
    @DeleteMapping("/{id}")
    ResponseEntity<CourseDto> deleteCourseById(@PathVariable long id);

    /**
     * Create a new course.
     *
     * @param courseDto new course
     * @return the course created
     */
    @PostMapping("/")
    ResponseEntity<CourseDto> createCourse(@RequestBody CourseDto courseDto);

    /**
     * Update a course.
     *
     * @param courseDto course to update
     * @return the course updated
     */
    @PutMapping("/")
    ResponseEntity<CourseDto> updateCourse(@RequestBody CourseDto courseDto);
}
