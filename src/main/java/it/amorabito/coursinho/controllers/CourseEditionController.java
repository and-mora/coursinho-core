package it.amorabito.coursinho.controllers;

import it.amorabito.coursinho.exceptions.EntityNotFoundException;
import it.amorabito.coursinho.model.dtos.CourseEditionDto;
import it.amorabito.coursinho.model.dtos.ModuleDto;
import it.amorabito.coursinho.model.dtos.WeeklySessionDto;
import it.amorabito.coursinho.model.entities.CourseEdition;
import it.amorabito.coursinho.model.entities.Module;
import it.amorabito.coursinho.model.entities.WeeklySession;
import it.amorabito.coursinho.model.mapper.CourseEditionMapper;
import it.amorabito.coursinho.model.mapper.ModuleMapper;
import it.amorabito.coursinho.model.mapper.WeeklySessionMapper;
import it.amorabito.coursinho.services.abstractions.CourseEditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api/course-edition")
@CrossOrigin
public class CourseEditionController {

    private CourseEditionService courseEditionService;

    private CourseEditionMapper courseEditionMapper;

    private ModuleMapper moduleMapper;

    private WeeklySessionMapper weeklySessionMapper;

    @Autowired
    public CourseEditionController(CourseEditionService courseEditionService,
                                   CourseEditionMapper courseEditionMapper,
                                   ModuleMapper moduleMapper,
                                   WeeklySessionMapper weeklySessionMapper) {
        this.courseEditionService = courseEditionService;
        this.courseEditionMapper = courseEditionMapper;
        this.moduleMapper = moduleMapper;
        this.weeklySessionMapper = weeklySessionMapper;
    }

    /**
     * Get all Course Edition
     */
    @GetMapping("/")
    public ResponseEntity<Collection<CourseEditionDto>> getAllCoursesEditions() {
        Collection<CourseEdition> listCourseEdition = courseEditionService.getAllCoursesEditions();
        Collection<CourseEditionDto> result = courseEditionMapper.toDtoList(listCourseEdition);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseEditionDto> getCourseEditionById(@PathVariable long id) {
        Optional<CourseEdition> opt = courseEditionService.getCourseEditionById(id);
        if (opt.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(courseEditionMapper.toDto(opt.get()), HttpStatus.OK);
    }

    @GetMapping("/{id}/modules")
    public ResponseEntity<Collection<ModuleDto>> getModulesByCourseEditionId(@PathVariable long id) {
        // retrieve data
        Collection<Module> list = this.courseEditionService.getModuleByCourseEditionId(id);
        // conversion from entity to dto
        Collection<ModuleDto> result = moduleMapper.toDtoList(list);
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
        Collection<CourseEditionDto> result = courseEditionMapper.toDtoList(editions);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * Create a new Course Edition
     */
    @PostMapping("/")
    public ResponseEntity<CourseEditionDto> createCourseEdition(@RequestBody CourseEditionDto courseEditionDto) {
        CourseEdition courseEdition = courseEditionMapper.toEntity(courseEditionDto);
        CourseEdition saved;

        try {
            saved = courseEditionService.createCourseEdition(courseEdition);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        CourseEditionDto saveDto = courseEditionMapper.toDto(saved);
        return new ResponseEntity<>(saveDto, HttpStatus.CREATED);
    }

    @PostMapping("/module")
    public ResponseEntity<ModuleDto> createModule(@RequestBody ModuleDto dto) {
        Module module = moduleMapper.toEntity(dto);
        Module saved;

        try {
            saved = courseEditionService.createModule(module);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ModuleDto saveDto = moduleMapper.toDto(saved);
        return new ResponseEntity<>(saveDto, HttpStatus.CREATED);
    }

    @PostMapping("/weekly-session")
    public ResponseEntity<WeeklySessionDto> createWeeklySession(@RequestBody WeeklySessionDto dto) {
        WeeklySession ws = weeklySessionMapper.toEntity(dto);
        WeeklySession saved;

        try {
            saved = courseEditionService.createWeeklySession(ws);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        WeeklySessionDto saveDto = weeklySessionMapper.toDto(saved);
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
     */
    @PutMapping("/")
    public ResponseEntity<CourseEditionDto> updateCourseEdition(@RequestBody CourseEditionDto courseEditionDto) {

        CourseEdition courseEdition = courseEditionMapper.toEntity(courseEditionDto);
        CourseEdition saved = null;
        try {
            saved = courseEditionService.createCourseEdition(courseEdition);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
        }

        if (saved != null) {
            CourseEditionDto saveDto = courseEditionMapper.toDto(saved);
            return new ResponseEntity<>(saveDto, HttpStatus.OK);
        }

        return ResponseEntity.notFound().build();
    }
}
