package it.amorabito.coursinho.repositories.custom;

import it.amorabito.coursinho.model.dtos.CourseFilter;
import it.amorabito.coursinho.model.entities.Course;

import java.util.Collection;

public interface CourseRepositoryCustom {
    Collection<Course> findFiltered(CourseFilter courseFilter);
}
