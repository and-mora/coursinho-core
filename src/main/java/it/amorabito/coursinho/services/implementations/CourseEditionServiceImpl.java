package it.amorabito.coursinho.services.implementations;

import it.amorabito.coursinho.model.entities.Classroom;
import it.amorabito.coursinho.model.entities.Course;
import it.amorabito.coursinho.model.entities.CourseEdition;
import it.amorabito.coursinho.model.entities.Module;
import it.amorabito.coursinho.exceptions.EntityNotFoundException;
import it.amorabito.coursinho.model.entities.Person;
import it.amorabito.coursinho.model.entities.WeeklySession;
import it.amorabito.coursinho.repositories.*;
import it.amorabito.coursinho.services.abstractions.CourseEditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

@Service
@Transactional
public class CourseEditionServiceImpl implements CourseEditionService {

    private CourseEditionRepository courseEditionRepo;
    private CourseRepository courseRepo;
    private PersonRepository personRepo;
    private ModuleRepository moduleRepo;
    private ClassroomRepository classroomRepo;
    private WeeklySessionRepository weeklySessionRepo;

    @Autowired
    public CourseEditionServiceImpl(CourseEditionRepository courseEditionRepo,
                                    CourseRepository courseRepo,
                                    PersonRepository personRepo,
                                    ModuleRepository moduleRepo,
                                    ClassroomRepository classroomRepo,
                                    WeeklySessionRepository weeklySessionRepo) {
        this.courseEditionRepo = courseEditionRepo;
        this.courseRepo = courseRepo;
        this.personRepo = personRepo;
        this.moduleRepo = moduleRepo;
        this.classroomRepo = classroomRepo;
        this.weeklySessionRepo = weeklySessionRepo;
    }

    @Override
    public Optional<CourseEdition> getCourseEditionById(long id) {
        return this.courseEditionRepo.findById(id);
    }

    @Override
    public Collection<Module> getModuleByCourseEditionId(long editionId) {
        return this.moduleRepo.getByCouseEditionId(editionId);
    }

    @Override
    public Collection<CourseEdition> getByCourse(long id) throws EntityNotFoundException {
        Optional<Course> opt = this.courseRepo.findById(id);

        if (opt.isEmpty()) {
            throw new EntityNotFoundException("course con id " + id + " non trovato");
        }

        return this.courseEditionRepo.findByCourse(opt.get());
    }

    @Override
    public Collection<CourseEdition> getAllCoursesEditions() {
        return this.courseEditionRepo.findAll();
    }

    @Override
    public Optional<CourseEdition> getFirstByCourseOrderByStartDateDesc(Course course) {
        return this.courseEditionRepo.findFirstByCourseOrderByStartDateDesc(course);
    }

    /**
     * Create a new edition course
     */
    @Override
    public CourseEdition createCourseEdition(CourseEdition courseEdition) throws EntityNotFoundException {
        Optional<Person> tutor = personRepo.findById(courseEdition.getTutor().getId());
        if (tutor.isEmpty()) {
            throw new EntityNotFoundException("tutore con id " + courseEdition.getTutor().getId() + " non trovato");
        }
        courseEdition.setTutor(tutor.get());

        Optional<Classroom> classroom = classroomRepo.findById(courseEdition.getClassroom().getId());
        if (classroom.isEmpty()) {
            throw new EntityNotFoundException("classroom con id " + courseEdition.getClassroom().getId() + " non trovata");
        }
        courseEdition.setClassroom(classroom.get());

        Optional<Course> course = courseRepo.findById(courseEdition.getCourse().getId());
        if (course.isEmpty()) {
            throw new EntityNotFoundException("course con id " + courseEdition.getCourse().getId() + " non trovato");
        }
        courseEdition.setCourse(course.get());

        return this.courseEditionRepo.save(courseEdition);
    }

    @Override
    public Module createModule(Module module) throws EntityNotFoundException {
        Optional<Person> teacher = personRepo.findById(module.getTeacher().getId());
        if (teacher.isEmpty()) {
            throw new EntityNotFoundException("persona con id " + module.getTeacher().getId() + " non trovata");
        }

        Optional<CourseEdition> courseEdition = courseEditionRepo.findById(module.getEdition().getId());
        if (courseEdition.isEmpty()) {
            throw new EntityNotFoundException("edizione con id " + module.getEdition().getId() + " non trovata");
        }

        module.setTeacher(teacher.get());
        module.setEdition(courseEdition.get());

        return this.moduleRepo.save(module);
    }

    @Override
    public WeeklySession createWeeklySession(WeeklySession weeklySession) throws EntityNotFoundException {
        Optional<CourseEdition> courseEdition = courseEditionRepo.findById(weeklySession.getEdition().getId());
        if (courseEdition.isEmpty()) {
            throw new EntityNotFoundException("edizione con id " + weeklySession.getEdition().getId() + " non trovata");
        }

        weeklySession.setEdition(courseEdition.get());

        return this.weeklySessionRepo.save(weeklySession);
    }

    @Override
    public void deleteCourseEdition(long id) {
        this.courseEditionRepo.deleteById(id);
    }
}
