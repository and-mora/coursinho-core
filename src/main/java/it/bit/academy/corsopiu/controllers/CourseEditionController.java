package it.bit.academy.corsopiu.controllers;

import it.bit.academy.corsopiu.dtos.CourseEditionDto;
import it.bit.academy.corsopiu.dtos.ModuleDto;
import it.bit.academy.corsopiu.entities.CourseEdition;
import it.bit.academy.corsopiu.entities.Module;
import it.bit.academy.corsopiu.exceptions.EntityNotFoundException;
import it.bit.academy.corsopiu.services.abstractions.CourseEditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/course-edition")
@CrossOrigin
public class CourseEditionController {

    private CourseEditionService courseEditionService;

    @Autowired
    public CourseEditionController(CourseEditionService courseEditionService) {
        this.courseEditionService = courseEditionService;
    }

    /**
     * Get all Course Edition
     *
     * @return
     */
    @GetMapping("/")
    public ResponseEntity<Collection<CourseEditionDto>> getAllCoursesEditions() {
        Collection<CourseEdition> listCourseEdition = courseEditionService.getAllCoursesEditions();
        List<CourseEditionDto> result = listCourseEdition.stream().map(CourseEditionDto::new).collect(Collectors.toList());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<CourseEditionDto> getCourseEditionById(@PathVariable long id) {
        Optional<CourseEdition> opt = courseEditionService.getCourseEditionById(id);
        if (opt.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new CourseEditionDto(opt.get()), HttpStatus.OK);
    }

    /**
     * @param id
     * @return
     */
    @GetMapping("/{id}/modules")
    public ResponseEntity<Collection<ModuleDto>> getModulesByCourseEditionId(@PathVariable long id) {
        // retrieve data
        Collection<Module> list = this.courseEditionService.getModuleByCourseEditionId(id);
        // conversion from entity to dto
        List<ModuleDto> result = list.stream().map(ModuleDto::new).collect(Collectors.toList());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * Get a list of Course Edition
     *
     * @param id key of the course
     * @return List Dto Course Edition
     */
    @GetMapping("/byCourseId/{id}")
    public ResponseEntity<Collection<CourseEditionDto>> getByCourse(@PathVariable long id) {
        Collection<CourseEdition> editions;
        try {
            editions = this.courseEditionService.getByCourse(id);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<CourseEditionDto> result = editions.stream().map(CourseEditionDto::new).collect(Collectors.toList());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * Create a new Course Edition
     *
     * @param courseEditionDto
     * @return
     */
    @PostMapping("/")
    public ResponseEntity<CourseEditionDto> createCourseEdition(@RequestBody CourseEditionDto courseEditionDto) {
        CourseEdition courseEdition = courseEditionDto.toCourseEdition();
        CourseEdition saved = null;

        try {
            saved = courseEditionService.createCourseEdition(courseEdition);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
        }
        CourseEditionDto saveDto = new CourseEditionDto(saved);
        return new ResponseEntity<>(saveDto, HttpStatus.CREATED);
    }

    /**
     * Delete a Course Edition
     *
     * @param id key of the course edition
     * @return HttpStatus
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<CourseEditionDto> deleteCourseById(@PathVariable long id) {
        Optional<CourseEdition> courseEdition = courseEditionService.getCourseEditionById(id);
        if (courseEdition.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else {
            courseEditionService.deleteCourseEdition(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }

    }

    /**
     * Update the course edition
     *
     * @param courseEditionDto
     * @return
     */
    @PutMapping("/")
    public ResponseEntity<CourseEditionDto> updateCourseEdition(@RequestBody CourseEditionDto courseEditionDto) {
//        Optional<CourseEdition> newCourseEdition = courseEditionService.getCourseEditionById(courseEditionDto.getCourseId());
//        if (newCourseEdition.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        CourseEdition courseEdition = courseEditionDto.toCourseEdition();
        CourseEdition saved = null;
        try {
            saved = courseEditionService.createCourseEdition(courseEdition);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
        }
        CourseEditionDto saveDto = new CourseEditionDto(saved);
        return new ResponseEntity<>(saveDto, HttpStatus.OK);
    }
}
