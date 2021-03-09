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

    @GetMapping("/")
    public ResponseEntity<Collection<CourseDto>> allCourses() {
        // recuperiamo l'elenco dei corsi dal service
        Collection<Course> listaCorsi = courseService.getCourses();
        // conversione da entity a dto
//        return listaCorsi.stream().map(e -> new CourseDto(e)).collect(Collectors.toList());
        List<CourseDto> result = listaCorsi.stream().map(CourseDto::new).collect(Collectors.toList());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/categoriesCount")
    public Collection<CategoryData> categoriesCount() {
        return courseService.getCategoriesCount();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDto> findCourseById(@PathVariable long id) {

        Optional<Course> opt = courseService.getCourseById(id);

        if(opt.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new CourseDto(opt.get()), HttpStatus.OK);

    }


}
