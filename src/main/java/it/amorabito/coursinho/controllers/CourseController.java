package it.amorabito.coursinho.controllers;

import it.amorabito.coursinho.model.dtos.CourseDto;
import it.amorabito.coursinho.model.dtos.CourseEditionPresentation;
import it.amorabito.coursinho.model.entities.Course;
import it.amorabito.coursinho.model.entities.CourseEdition;
import it.amorabito.coursinho.model.mapper.CourseMapper;
import it.amorabito.coursinho.services.abstractions.CourseEditionService;
import it.amorabito.coursinho.services.abstractions.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/course")
@CrossOrigin
@RequiredArgsConstructor
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
    public ResponseEntity<Collection<CourseDto>> allCourses() {
        // recuperiamo l'elenco dei corsi dal service
        Collection<Course> listaCorsi = courseService.getCourses();
        // conversione da entity a dto
        Collection<CourseDto> result = courseMapper.toDtoList(listaCorsi);
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

//    @GetMapping("/coursesBetweenPrices/{min}-{max}")
//    public ResponseEntity<Collection<CourseDto>> getCoursesBetweenPrices(@PathVariable double min, @PathVariable double max) {
//
//        Collection<Course> courses = this.courseService.getCoursesBetweenPrices(min, max);
//        List<CourseDto> result = courses.stream().map(CourseDto::new).collect(Collectors.toList());
//
//        return new ResponseEntity<>(result, HttpStatus.OK);
//    }

    /**
     * Get courses with edition and filter on price if priceRange is present
     *
     * @param priceRange
     * @return
     */
    @GetMapping("/search")
    public ResponseEntity<Collection<CourseEditionPresentation>> getCoursesWithOneEdition(
            @RequestParam Optional<List<Double>> priceRange) {

        Collection<Course> courses;

        if (priceRange.isPresent() && priceRange.get().size() > 0) {

            Optional<Double> minPrice = priceRange.get().stream().min(Comparator.naturalOrder());
            Optional<Double> maxPrice = priceRange.get().stream().max(Comparator.naturalOrder());
            courses = this.courseService.getCoursesWithEditionsByPrice(minPrice.get(), maxPrice.get());

        } else {
            courses = this.courseService.getCoursesWithEditions();
        }


        Collection<CourseEditionPresentation> results = new ArrayList<>(courses.size());

        for (Course c : courses) {
            Optional<CourseEdition> opt = this.courseEditionService.getFirstByCourseOrderByStartDateDesc(c);

            if (opt.isEmpty()) continue;

            CourseEditionPresentation cep = new CourseEditionPresentation();
            cep.setCourseId(c.getId());
            cep.setCourseEditionId(opt.get().getId());
            cep.setCategory(c.getCategory());
            cep.setName(c.getName());
            cep.setPrice(c.getPrice());

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
        return new ResponseEntity<>(courseMapper.toDto(opt.get()), HttpStatus.OK);
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
        Course course = courseMapper.toEntity(dto);
        Course saved = courseService.saveCourse(course);
        return new ResponseEntity<>(courseMapper.toDto(saved), HttpStatus.CREATED);
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

        Course course = courseMapper.toEntity(courseDto);
        Course saved = courseService.saveCourse(course);
        return new ResponseEntity<>(courseMapper.toDto(saved), HttpStatus.OK);
    }
}
