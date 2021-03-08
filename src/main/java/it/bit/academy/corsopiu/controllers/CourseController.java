package it.bit.academy.corsopiu.controllers;

import it.bit.academy.corsopiu.dtos.CourseDto;
import it.bit.academy.corsopiu.entities.Course;
import it.bit.academy.corsopiu.services.abstractions.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    private SchedulerService schedulerService;

    @Autowired
    public CourseController(SchedulerService schedulerService) {
        this.schedulerService = schedulerService;
    }

    @GetMapping("/")
    public Collection<CourseDto> allCourses() {
        // recuperiamo l'elenco dei corsi dal service
        Collection<Course> listaCorsi = schedulerService.getCourses();
        // conversione da entity a dto
//        return listaCorsi.stream().map(e -> new CourseDto(e)).collect(Collectors.toList());
        return listaCorsi.stream().map(CourseDto::new).collect(Collectors.toList());
    }

}
