package it.amorabito.coursinho.controllers;

import it.amorabito.coursinho.exceptions.EntityNotFoundException;
import it.amorabito.coursinho.model.dtos.ApplicationDto;
import it.amorabito.coursinho.services.abstractions.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/application")
@CrossOrigin
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationService applicationService;

    @GetMapping("/{select}/{id}")
    public ResponseEntity<Collection<ApplicationDto>> getBySelect(@PathVariable String select, @PathVariable long id) {
        Collection<ApplicationDto> applications;

        try {
            switch (select) {
                case "student":
                    applications = applicationService.getByStudent(id);
                    break;
                case "edition":
                    applications = applicationService.getByEdition(id);
                    break;
                default:
                    return ResponseEntity.badRequest().build();

            }
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(applications);
    }

    @PostMapping("/")
    public ResponseEntity<ApplicationDto> saveApplication(@RequestBody ApplicationDto applicationDto) {
        ApplicationDto applicationSaved;

        try {
            applicationSaved = applicationService.save(applicationDto);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(applicationSaved);
    }

}
