package it.bit.academy.corsopiu.services.implementations;

import it.bit.academy.corsopiu.entities.Course;
import it.bit.academy.corsopiu.entities.CourseEdition;
import it.bit.academy.corsopiu.entities.Person;
import it.bit.academy.corsopiu.exceptions.EntityNotFoundException;
import it.bit.academy.corsopiu.repositories.CourseEditionRepository;
import it.bit.academy.corsopiu.repositories.CourseRepository;
import it.bit.academy.corsopiu.repositories.PersonRepository;
import it.bit.academy.corsopiu.services.abstractions.CourseEditionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Optional;

public class CourseEditionServiceImpl implements CourseEditionService {

    private CourseEditionRepository courseEditionRepo;
    private CourseRepository courseRepo;
    private PersonRepository personRepository;

    @Autowired
    public CourseEditionServiceImpl(CourseEditionRepository courseEditionRepo, CourseRepository courseRepo, PersonRepository personRepository) {
        this.courseEditionRepo = courseEditionRepo;
        this.courseRepo = courseRepo;
        this.personRepository = personRepository;

    }


    @Override
    public Optional<CourseEdition> getCourseEditionById(long id) {
        return this.courseEditionRepo.findById(id);
    }

    @Override
    public CourseEdition createCourseEdition(CourseEdition courseEdition) throws EntityNotFoundException {
        Optional<Person> tutor = personRepository.findById(courseEdition.getTutor().getId());
        if (tutor.isEmpty()) {
            throw new EntityNotFoundException("tutore con id" + courseEdition.getTutor().getId() + " non trovato");
        }
        

        return this.courseEditionRepo.save(courseEdition);
    }
}
