package it.bit.academy.corsopiu.services.abstractions;

import it.bit.academy.corsopiu.entities.CourseEdition;
import it.bit.academy.corsopiu.exceptions.EntityNotFoundException;

import java.util.Collection;
import java.util.Optional;

public interface CourseEditionService {

    Optional<CourseEdition> getCourseEditionById(long id);

    CourseEdition createCourseEdition(CourseEdition courseEdition) throws EntityNotFoundException;
}
