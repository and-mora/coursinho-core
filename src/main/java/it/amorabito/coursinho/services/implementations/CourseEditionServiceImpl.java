package it.amorabito.coursinho.services.implementations;

import it.amorabito.coursinho.exceptions.EntityNotFoundException;
import it.amorabito.coursinho.model.dtos.CourseDto;
import it.amorabito.coursinho.model.dtos.CourseEditionDto;
import it.amorabito.coursinho.model.dtos.ModuleDto;
import it.amorabito.coursinho.model.dtos.WeeklySessionDto;
import it.amorabito.coursinho.model.entities.Classroom;
import it.amorabito.coursinho.model.entities.Course;
import it.amorabito.coursinho.model.entities.CourseEdition;
import it.amorabito.coursinho.model.entities.Person;
import it.amorabito.coursinho.model.mapper.CourseEditionMapper;
import it.amorabito.coursinho.model.mapper.CourseMapper;
import it.amorabito.coursinho.model.mapper.ModuleMapper;
import it.amorabito.coursinho.model.mapper.WeeklySessionMapper;
import it.amorabito.coursinho.repositories.*;
import it.amorabito.coursinho.services.abstractions.CourseEditionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CourseEditionServiceImpl implements CourseEditionService {

    private final CourseEditionRepository courseEditionRepo;
    private final CourseRepository courseRepo;
    private final PersonRepository personRepo;
    private final ModuleRepository moduleRepo;
    private final ClassroomRepository classroomRepo;
    private final WeeklySessionRepository weeklySessionRepo;
    private final CourseEditionMapper courseEditionMapper;
    private final ModuleMapper moduleMapper;
    private final WeeklySessionMapper weeklySessionMapper;
    private final CourseMapper courseMapper;


    @Override
    public CourseEditionDto getCourseEditionById(long editionId) {
        var courseEdition = courseEditionRepo.findById(editionId).orElseThrow();

        return courseEditionMapper.toDto(courseEdition);
    }

    @Override
    public Collection<ModuleDto> getModuleByCourseEditionId(long editionId) {
        return moduleMapper.toDtoList(moduleRepo.getByCouseEditionId(editionId));
    }

    @Override
    public Collection<CourseEditionDto> getByCourse(long id) {
        var course = courseRepo.findById(id).orElseThrow();

        return courseEditionMapper.toDtoList(courseEditionRepo.findByCourse(course));
    }

    @Override
    public Collection<CourseEditionDto> getAllCoursesEditions() {
        return courseEditionMapper.toDtoList(courseEditionRepo.findAll());
    }

    @Override
    public CourseEditionDto getFirstByCourseOrderByStartDateDesc(CourseDto courseDto) {
        var courseEdition = courseEditionRepo.findFirstByCourseOrderByStartDateDesc(courseMapper.toEntity(courseDto));
        if (courseEdition.isEmpty()) {
            return null;
        }
        return courseEditionMapper.toDto(courseEdition.get());
    }

    /**
     * Create a new edition course
     */
    @Override
    public CourseEditionDto createCourseEdition(CourseEditionDto courseEdition) throws EntityNotFoundException {
        Optional<Person> tutor = personRepo.findById(courseEdition.getTutorId());
        if (tutor.isEmpty()) {
            throw new EntityNotFoundException("tutore con id " + courseEdition.getTutorId() + " non trovato");
        }

        Optional<Classroom> classroom = classroomRepo.findById(courseEdition.getClassroomId());
        if (classroom.isEmpty()) {
            throw new EntityNotFoundException("classroom con id " + courseEdition.getClassroomId() + " non trovata");
        }

        Optional<Course> course = courseRepo.findById(courseEdition.getCourseId());
        if (course.isEmpty()) {
            throw new EntityNotFoundException("course con id " + courseEdition.getCourseId() + " non trovato");
        }

        var courseEditionSaved = courseEditionRepo.save(courseEditionMapper.toEntity(courseEdition));

        return courseEditionMapper.toDto(courseEditionSaved);
    }

    @Override
    public ModuleDto createModule(ModuleDto moduleDto) throws EntityNotFoundException {
        Optional<Person> teacher = personRepo.findById(moduleDto.getTeacherId());
        if (teacher.isEmpty()) {
            throw new EntityNotFoundException("persona con id " + moduleDto.getTeacherId() + " non trovata");
        }

        Optional<CourseEdition> courseEdition = courseEditionRepo.findById(moduleDto.getEditionId());
        if (courseEdition.isEmpty()) {
            throw new EntityNotFoundException("edizione con id " + moduleDto.getEditionId() + " non trovata");
        }

        var moduleSaved = moduleRepo.save(moduleMapper.toEntity(moduleDto));

        return moduleMapper.toDto(moduleSaved);
    }

    @Override
    public WeeklySessionDto createWeeklySession(WeeklySessionDto weeklySessionDto) throws EntityNotFoundException {
        Optional<CourseEdition> courseEdition = courseEditionRepo.findById(weeklySessionDto.getEditionId());
        if (courseEdition.isEmpty()) {
            throw new EntityNotFoundException("edizione con id " + weeklySessionDto.getEditionId() + " non trovata");
        }

        var saved = weeklySessionRepo.save(weeklySessionMapper.toEntity(weeklySessionDto));

        return weeklySessionMapper.toDto(saved);
    }

    @Override
    public void deleteCourseEdition(long id) {
        courseEditionRepo.deleteById(id);
    }

    @Override
    public Collection<CourseDto> getMostRecentEdition(Collection<CourseDto> filteredCourses) {
        for (var course : filteredCourses) {
            course.getEditions().stream().max(Comparator.comparing(CourseEditionDto::getStartDate))
                    .ifPresentOrElse(courseFiltered -> course.setEditions(Collections.singletonList(courseFiltered)),
                            () -> course.setEditions(Collections.emptyList()));
        }

        return filteredCourses;
    }
}
