package it.amorabito.coursinho.controllers;

import it.amorabito.coursinho.model.dtos.ApplicationDto;
import it.amorabito.coursinho.model.entities.Application;
import it.amorabito.coursinho.exceptions.EntityNotFoundException;
import it.amorabito.coursinho.services.abstractions.ApplicationService;
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

    @GetMapping("/{select}/{id}")
    public ResponseEntity<Collection<ApplicationDto>> getBySelect(@PathVariable String select, @PathVariable long id) {
        Collection<Application> apps;

        try {
            switch (select){
                case "student":
                    apps = this.applicationService.getByStudent(id);
                    break;
                case "edition":
                    apps = this.applicationService.getByEdition(id);
                    break;
                default:
                    return ResponseEntity.badRequest().build();

            }
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
