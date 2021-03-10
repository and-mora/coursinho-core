package it.bit.academy.corsopiu.controllers;

import it.bit.academy.corsopiu.dtos.CategoryData;
import it.bit.academy.corsopiu.dtos.CourseDto;
import it.bit.academy.corsopiu.entities.Course;
import it.bit.academy.corsopiu.services.abstractions.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/course")
@CrossOrigin
public class CourseController {

    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    /**
     * Get a collection of courses
     *
     * @return
     */
    @GetMapping("/")
    public ResponseEntity<Collection<CourseDto>> allCourses() {
        // recuperiamo l'elenco dei corsi dal service
        Collection<Course> listaCorsi = courseService.getCourses();
        // conversione da entity a dto
//        return listaCorsi.stream().map(e -> new CourseDto(e)).collect(Collectors.toList());
        List<CourseDto> result = listaCorsi.stream().map(CourseDto::new).collect(Collectors.toList());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * Get a collection of categories
     *
     * @return
     */
    @GetMapping("/categoriesCount")
    public Collection<CategoryData> categoriesCount() {
        return courseService.getCategoriesCount();
    }

    /**
     * @return
     */
    @GetMapping("/maxPrice")
    public Double getMaxPrice() {
        return courseService.getCourseMaxPrice();
    }

    /**
     * @return
     */
    @GetMapping("/minPrice")
    public Double getMinPrice() {
        return courseService.getCourseMinPrice();
    }

    /**
     * Get only one course
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<CourseDto> findCourseById(@PathVariable long id) {
        Optional<Course> opt = courseService.getCourseById(id);
        if (opt.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new CourseDto(opt.get()), HttpStatus.OK);
    }

    /**
     * Delete a course
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<CourseDto> deleteCourseById(@PathVariable long id) {

        Optional<Course> course = courseService.getCourseById(id);
        if (course.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else {
            courseService.deleteCourse(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    /**
     * Create a new course
     *
     * @param dto
     * @return
     */
    @PostMapping("/")
    public ResponseEntity<CourseDto> createCourse(@RequestBody CourseDto dto) {
        Course course = dto.toCourse();
        Course saved = courseService.saveCourse(course);
        CourseDto saveDto = new CourseDto(saved);
        return new ResponseEntity<>(saveDto, HttpStatus.CREATED);
    }

    /**
     * Update course
     *
     * @param courseDto
     * @return dto course update
     */
    @PutMapping("/")
    public ResponseEntity<CourseDto> updateCourse(@RequestBody CourseDto courseDto) {
        Optional<Course> newCourse = courseService.getCourseById(courseDto.getId());
        if (newCourse.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        Course course = courseDto.toCourse();
        Course saved = courseService.saveCourse(course);
        CourseDto saveDto = new CourseDto(saved);
        return new ResponseEntity<>(saveDto, HttpStatus.OK);
    }
}
