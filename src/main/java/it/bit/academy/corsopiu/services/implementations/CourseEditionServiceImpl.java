package it.bit.academy.corsopiu.services.implementations;

import it.bit.academy.corsopiu.entities.CourseEdition;
import it.bit.academy.corsopiu.repositories.CourseEditionRepository;
import it.bit.academy.corsopiu.services.abstractions.CourseEditionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Optional;

public class CourseEditionServiceImpl implements CourseEditionService {

    private CourseEditionRepository courseEditionRepo;

    @Autowired
    public CourseEditionServiceImpl(CourseEditionRepository courseEditionRepo){
        this.courseEditionRepo = courseEditionRepo;
    }

    @Override
    public Optional<CourseEdition> getCourseEditionById(long id) {
        return this.courseEditionRepo.findById(id);
    }
}
