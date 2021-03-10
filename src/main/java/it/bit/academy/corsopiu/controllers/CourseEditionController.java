package it.bit.academy.corsopiu.controllers;

import it.bit.academy.corsopiu.dtos.CourseEditionDto;
import it.bit.academy.corsopiu.dtos.ModuleDto;
import it.bit.academy.corsopiu.entities.CourseEdition;
import it.bit.academy.corsopiu.entities.Module;
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
@RequestMapping("/api/courseEdition")
@CrossOrigin
public class CourseEditionController {

    private CourseEditionService courseEditionService;

    @Autowired
    public CourseEditionController(CourseEditionService courseEditionService) {
        this.courseEditionService = courseEditionService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseEditionDto> findCourseEditionById(@PathVariable long id) {
        Optional<CourseEdition> opt = courseEditionService.getCourseEditionById(id);
        if (opt.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new CourseEditionDto(opt.get()), HttpStatus.OK);
    }

    @GetMapping("/modules/{id}")
    public ResponseEntity<Collection<ModuleDto>> findModulesByCourseEditionId(@PathVariable long id) {
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
    public ResponseEntity<Collection<CourseEditionDto>> findCourseEditionsByCourseId(@PathVariable long id) {
        Collection<CourseEdition> listCourseEditionById = this.courseEditionService.getAllCoursesEditionsByIdCourse(id);
        List<CourseEditionDto> result = listCourseEditionById.stream().map(CourseEditionDto::new).collect(Collectors.toList());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    //courseId
    //findCourseEditionsByCourseId
}
