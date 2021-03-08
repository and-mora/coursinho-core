package it.bit.academy.corsopiu.services.implementations;

import it.bit.academy.corsopiu.entities.Course;
import it.bit.academy.corsopiu.repositories.CourseRepository;
import it.bit.academy.corsopiu.services.abstractions.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SchedulerServiceImpl implements SchedulerService {

    private CourseRepository courseRepo;

    @Autowired
    public SchedulerServiceImpl(CourseRepository courseRepo) {
        this.courseRepo = courseRepo;
    }

    @Override
    public Collection<Course> getCourses() {
        return (Collection<Course>) this.courseRepo.findAll();
    }
}
