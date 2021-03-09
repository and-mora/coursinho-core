package it.bit.academy.corsopiu.services.implementations;

import it.bit.academy.corsopiu.dtos.CategoryData;
import it.bit.academy.corsopiu.entities.Course;
import it.bit.academy.corsopiu.repositories.CourseRepository;
import it.bit.academy.corsopiu.services.abstractions.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepo;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepo) {
        this.courseRepo = courseRepo;
    }

    /**
     * Get a collection of courses
     *
     * @return
     */
    @Override
    public Collection<Course> getCourses() {
        return this.courseRepo.findAll();
    }

    /**
     * Get a collection of categories
     *
     * @return
     */
    @Override
    public Collection<CategoryData> getCategoriesCount() {
        return this.courseRepo.getCategoriesCount();
    }

    /**
     * Get the maximum price among courses
     *
     * @return
     */
    @Override
    public Double getCourseMaxPrice() {
        return this.courseRepo.getMaxPrice();
    }

    /**
     * Get the minimum price among courses
     *
     * @return
     */
    @Override
    public Double getCourseMinPrice() {
        return this.courseRepo.getMinPrice();
    }

    /**
     * Get only one course
     *
     * @param id
     * @return
     */
    @Override
    public Optional<Course> getCourseById(long id) {
        return this.courseRepo.findById(id);
    }

    /**
     * Delete course
     *
     * @param id
     */
    @Override
    public void deleteCourse(long id) {
        this.courseRepo.deleteById(id);
    }

    /**
     * Crea a new course
     *
     * @param course
     * @return
     */
    @Override
    public Course saveCourse(Course course) {
        return this.courseRepo.save(course);
    }

// crud per course edition
}
