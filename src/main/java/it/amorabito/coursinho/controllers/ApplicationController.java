package it.amorabito.coursinho.controllers;

import it.amorabito.coursinho.exceptions.EntityNotFoundException;
import it.amorabito.coursinho.model.dtos.ApplicationDto;
import it.amorabito.coursinho.model.entities.Application;
import it.amorabito.coursinho.model.mapper.ApplicationMapper;
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
    private final ApplicationMapper applicationMapper;

    @GetMapping("/{select}/{id}")
    public ResponseEntity<Collection<ApplicationDto>> getBySelect(@PathVariable String select, @PathVariable long id) {
        Collection<Application> apps;

        try {
            switch (select) {
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

        Collection<ApplicationDto> results = applicationMapper.toDtoList(apps);

        return new ResponseEntity<>(results, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<ApplicationDto> saveApplication(@RequestBody ApplicationDto dto) {
        Application appl = applicationMapper.toEntity(dto);

        try {
            this.applicationService.save(appl);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(applicationMapper.toDto(appl), HttpStatus.CREATED);
    }

}
