package it.amorabito.coursinho.services.implementations;

import it.amorabito.coursinho.model.dtos.CategoryData;
import it.amorabito.coursinho.model.entities.Course;
import it.amorabito.coursinho.repositories.CourseEditionRepository;
import it.amorabito.coursinho.repositories.CourseRepository;
import it.amorabito.coursinho.services.abstractions.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepo;
    private final CourseEditionRepository courseEditionRepo;

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
        return this.courseRepo.findByCategoriesCount();
    }

    /**
     * Get the maximum price among courses
     *
     * @return
     */
    @Override
    public Double getCourseMaxPrice() {
        return this.courseRepo.findByMaxPrice();
    }

    /**
     * Get the minimum price among courses
     *
     * @return
     */
    @Override
    public Double getCourseMinPrice() {
        return this.courseRepo.findByMinPrice();
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

//    @Override
//    public Page<Collection<Course>> getCoursesByCategoryLikePaged(String categoryLike, Paginator pg) {
//        return this.courseRepo.findByCategoryLikePaged(categoryLike, PageRequest.of(
//                pg.getNumPage(), pg.getElementsPerPage(),
//                Sort.by(Sort.Direction.DESC, pg.getOrderBy())));
//    }

    @Override
    public Collection<Course> getCoursesByCategoryLike(String categoryLike) {
        return this.courseRepo.findByCategoryLike(categoryLike);
    }

//    @Override
//    public Collection<Course> getCoursesBetweenPrices(double minPrice, double maxPrice) {
//        return this.courseRepo.findByPriceGreaterThanEqualAndPriceLessThanEqual(minPrice, maxPrice);
//    }

    @Override
    public Collection<Course> getCoursesWithEditions() {
        return this.courseRepo.findByCoursesWithEditions();
    }

    @Override
    public Collection<Course> getCoursesWithEditionsByPrice(double minPrice, double maxPrice) {
        return this.courseRepo.findByCoursesWithEditionsByPrices(minPrice, maxPrice);
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
