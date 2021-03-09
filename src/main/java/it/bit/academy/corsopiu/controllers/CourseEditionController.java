package it.bit.academy.corsopiu.controllers;

import it.bit.academy.corsopiu.dtos.CourseDto;
import it.bit.academy.corsopiu.dtos.CourseEditionDto;
import it.bit.academy.corsopiu.entities.Course;
import it.bit.academy.corsopiu.entities.CourseEdition;
import it.bit.academy.corsopiu.services.abstractions.CourseEditionService;
import it.bit.academy.corsopiu.services.abstractions.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/courseEdition")
@CrossOrigin
public class CourseEditionController {

    private CourseEditionService courseEditionService;

    @Autowired
    public CourseEditionController(CourseService courseService) {
        this.courseEditionService = courseEditionService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseEditionDto> findCourseEditionById(@PathVariable long id) {

        Optional<CourseEdition> opt = courseEditionService.getCourseEditionById(id);

        if(opt.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new CourseEditionDto(opt.get()), HttpStatus.OK);

    }

}
