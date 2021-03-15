package it.bit.academy.corsopiu.controllers;

import it.bit.academy.corsopiu.dtos.ClassroomDto;
import it.bit.academy.corsopiu.entities.Classroom;
import it.bit.academy.corsopiu.services.abstractions.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/classroom")
@CrossOrigin
public class ClassroomController {

    private ClassroomService classroomService;

    @Autowired
    public ClassroomController(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    @GetMapping("/")
    public ResponseEntity<Collection<ClassroomDto>> getAllClassrooms() {
        Collection<Classroom> data = this.classroomService.getAllClassrooms();

        return new ResponseEntity<>(data.stream().map(ClassroomDto::new).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassroomDto> getClassroomById(@PathVariable long id) {
        Optional<Classroom> opt = this.classroomService.getClassroomById(id);

        if (opt.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new ClassroomDto(opt.get()), HttpStatus.OK);
    }

    @GetMapping("/reals")
    public ResponseEntity<Collection<ClassroomDto>> getRealClassrooms() {
        List<ClassroomDto> results = this.classroomService.getRealClassrooms().stream().map(ClassroomDto::new).collect(Collectors.toList());
        return new ResponseEntity<>(results, HttpStatus.OK);
    }

    @GetMapping("/virtuals")
    public ResponseEntity<Collection<ClassroomDto>> getVirtualClassrooms() {
        List<ClassroomDto> results = this.classroomService.getVirtualClassrooms().stream().map(ClassroomDto::new).collect(Collectors.toList());
        return new ResponseEntity<>(results, HttpStatus.OK);
    }
}
