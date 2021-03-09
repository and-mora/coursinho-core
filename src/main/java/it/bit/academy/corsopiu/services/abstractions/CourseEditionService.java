package it.bit.academy.corsopiu.services.abstractions;

import it.bit.academy.corsopiu.entities.CourseEdition;

import java.util.Collection;
import java.util.Optional;

public interface CourseEditionService {

    Optional<CourseEdition> getCourseEditionById(long id);
}
