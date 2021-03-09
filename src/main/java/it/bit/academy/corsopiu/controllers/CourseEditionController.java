package it.bit.academy.corsopiu.controllers;

import it.bit.academy.corsopiu.services.abstractions.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/courseEdition")
@CrossOrigin
public class CourseEditionController {

    private CourseService courseService;

    @Autowired
    public CourseEditionController(CourseService courseService) {
        this.courseService = courseService;
    }
}
