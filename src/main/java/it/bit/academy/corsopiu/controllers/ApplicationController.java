package it.bit.academy.corsopiu.controllers;

import it.bit.academy.corsopiu.dtos.ApplicationDto;
import it.bit.academy.corsopiu.entities.Application;
import it.bit.academy.corsopiu.exceptions.EntityNotFoundException;
import it.bit.academy.corsopiu.services.abstractions.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/application")
@CrossOrigin
public class ApplicationController {

    private ApplicationService applicationService;

    @Autowired
    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/edition/{editionId}")
    public ResponseEntity<Collection<ApplicationDto>> getApplicationsByEdition(@PathVariable long editionId) {
        Collection<Application> apps = null;
        try {
            apps = this.applicationService.getApplicationsByEdition(editionId);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Collection<ApplicationDto> results = apps.stream().map(ApplicationDto::new).collect(Collectors.toList());

        return new ResponseEntity<>(results, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<ApplicationDto> saveApplication(@RequestBody ApplicationDto dto) {
        Application appl = dto.toApplication();

        try {
            this.applicationService.save(appl);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new ApplicationDto(appl), HttpStatus.CREATED);
    }

}
