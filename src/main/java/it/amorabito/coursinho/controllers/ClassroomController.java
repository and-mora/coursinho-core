package it.amorabito.coursinho.controllers;

import it.amorabito.coursinho.model.dtos.ClassroomDto;
import it.amorabito.coursinho.services.abstractions.ClassroomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/classroom")
@CrossOrigin
@RequiredArgsConstructor
@Slf4j
public class ClassroomController {

    private final ClassroomService classroomService;

    @GetMapping("/")
    public ResponseEntity<Collection<ClassroomDto>> getAllClassrooms() {
        log.info("getAllClassrooms");
        Collection<ClassroomDto> data = classroomService.getAllClassrooms();

        return ResponseEntity.ok(data);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassroomDto> getClassroomById(@PathVariable long id) {
        log.info("getClassroomById");
        ClassroomDto classroom = classroomService.getClassroomById(id);

        return ResponseEntity.ok(classroom);
    }

    @GetMapping("/reals")
    public ResponseEntity<Collection<ClassroomDto>> getRealClassrooms() {
        log.info("getRealClassrooms");
        Collection<ClassroomDto> results = classroomService.getRealClassrooms();

        return ResponseEntity.ok(results);
    }

    @GetMapping("/virtuals")
    public ResponseEntity<Collection<ClassroomDto>> getVirtualClassrooms() {
        log.info("getVirtualClassrooms");
        Collection<ClassroomDto> results = classroomService.getVirtualClassrooms();

        return ResponseEntity.ok(results);
    }
}
