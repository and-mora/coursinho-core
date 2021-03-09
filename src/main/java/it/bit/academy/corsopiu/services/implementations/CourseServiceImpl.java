package it.bit.academy.corsopiu.services.implementations;

import it.bit.academy.corsopiu.dtos.CategoryData;
import it.bit.academy.corsopiu.entities.Course;
import it.bit.academy.corsopiu.repositories.CourseRepository;
import it.bit.academy.corsopiu.services.abstractions.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepo;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepo) {
        this.courseRepo = courseRepo;
    }

    @Override
    public Collection<Course> getCourses() {
        return this.courseRepo.findAll();
    }

    @Override
    public Collection<CategoryData> getCategoriesCount() {
        return this.courseRepo.getCategoriesCount();
    }

    @Override
    public Optional<Course> getCourseById(long id) {
        return this.courseRepo.findById(id);
    }

    // crud per course edition
}
