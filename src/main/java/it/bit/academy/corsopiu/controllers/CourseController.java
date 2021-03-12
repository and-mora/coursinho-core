package it.bit.academy.corsopiu.controllers;

import it.bit.academy.corsopiu.dtos.CourseDto;
import it.bit.academy.corsopiu.dtos.CourseEditionPresentation;
import it.bit.academy.corsopiu.entities.Course;
import it.bit.academy.corsopiu.entities.CourseEdition;
import it.bit.academy.corsopiu.services.abstractions.CourseEditionService;
import it.bit.academy.corsopiu.services.abstractions.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/course")
@CrossOrigin
public class CourseController {

    private CourseService courseService;
    private CourseEditionService courseEditionService;

    @Autowired
    public CourseController(CourseService courseService,
                            CourseEditionService courseEditionService) {
        this.courseService = courseService;
        this.courseEditionService = courseEditionService;
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
        List<CourseDto> result = listaCorsi.stream().map(CourseDto::new).collect(Collectors.toList());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/select/{value}")
    public ResponseEntity<Object> getSelect(@PathVariable String value) {

        switch (value) {
            case "min-price":
                return new ResponseEntity<>(courseService.getCourseMinPrice(), HttpStatus.OK);
            case "max-price":
                return new ResponseEntity<>(courseService.getCourseMaxPrice(), HttpStatus.OK);
            case "categories-count":
                return new ResponseEntity<>(courseService.getCategoriesCount(), HttpStatus.OK);
            default:
                break;
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/coursesBetweenPrices/{min}-{max}")
    public ResponseEntity<Collection<CourseDto>> getCoursesBetweenPrices(@PathVariable double min, @PathVariable double max) {

        Collection<Course> courses = this.courseService.getCoursesBetweenPrices(min, max);
        List<CourseDto> result = courses.stream().map(CourseDto::new).collect(Collectors.toList());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/withEdition")
    public ResponseEntity<Collection<CourseEditionPresentation>> getCoursesWithOneEdition() {
        Collection<Course> courses = this.courseService.getCoursesWithEditions();
        Collection<CourseEditionPresentation> results = new ArrayList<>(courses.size());

        for (Course c : courses) {
            Optional<CourseEdition> opt = this.courseEditionService.getFirstByCourseOrderByStartDateDesc(c);

            if (opt.isEmpty()) {
                continue;
            }

            CourseEditionPresentation cep = new CourseEditionPresentation();
            cep.setCourseId(c.getId());
            cep.setCourseEditionId(opt.get().getId());
            cep.setCategory(c.getCategory());
            cep.setName(c.getName());

            results.add(cep);
        }

        return new ResponseEntity<>(results, HttpStatus.OK);
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
        
        courseService.deleteCourse(id);
        return new ResponseEntity<>(HttpStatus.OK);

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
