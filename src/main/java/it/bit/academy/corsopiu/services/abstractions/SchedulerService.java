package it.bit.academy.corsopiu.services.abstractions;

import it.bit.academy.corsopiu.entities.Course;

import java.util.Collection;

public interface SchedulerService {

    Collection<Course> getCourses();
}