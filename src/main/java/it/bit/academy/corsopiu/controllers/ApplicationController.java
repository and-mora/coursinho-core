package it.bit.academy.corsopiu.controllers;

import it.bit.academy.corsopiu.dtos.ApplicationDto;
import it.bit.academy.corsopiu.entities.Application;
import it.bit.academy.corsopiu.exceptions.EntityNotFoundException;
import it.bit.academy.corsopiu.services.abstractions.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/application")
@CrossOrigin
public class ApplicationController {

    private ApplicationService applicationService;

    @Autowired
    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping("/")
    public ResponseEntity<ApplicationDto> saveApplication(@RequestBody ApplicationDto dto) {
        Application appl = dto.toApplication();

        try {
            this.applicationService.saveApplication(appl);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new ApplicationDto(appl), HttpStatus.CREATED);
    }

}
