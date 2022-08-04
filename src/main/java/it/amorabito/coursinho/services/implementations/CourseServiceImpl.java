package it.amorabito.coursinho.services.implementations;

import it.amorabito.coursinho.model.dtos.CategoryData;
import it.amorabito.coursinho.model.dtos.CourseDto;
import it.amorabito.coursinho.model.dtos.CourseEditionPresentation;
import it.amorabito.coursinho.model.dtos.CourseFilter;
import it.amorabito.coursinho.model.mapper.CourseMapper;
import it.amorabito.coursinho.repositories.CourseRepository;
import it.amorabito.coursinho.repositories.specifications.CourseSpecification;
import it.amorabito.coursinho.services.abstractions.CourseEditionService;
import it.amorabito.coursinho.services.abstractions.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Transactional
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepo;
    private final CourseEditionService courseEditionService;
    private final CourseMapper courseMapper;

    /**
     * Get a collection of courses
     *
     * @return
     */
    @Override
    public Collection<CourseDto> getCourses() {
        return courseMapper.toDtoList(courseRepo.findAll());
    }

    /**
     * Get a collection of categories
     *
     * @return
     */
    @Override
    public Collection<CategoryData> getCategoriesCount() {
        return courseRepo.findByCategoriesCount();
    }

    /**
     * Get the maximum price among courses
     *
     * @return
     */
    @Override
    public Double getCourseMaxPrice() {
        return courseRepo.findByMaxPrice();
    }

    /**
     * Get the minimum price among courses
     *
     * @return
     */
    @Override
    public Double getCourseMinPrice() {
        return courseRepo.findByMinPrice();
    }

    /**
     * Get only one course
     *
     * @param id
     * @return
     */
    @Override
    public CourseDto getCourseById(long id) {
        return courseMapper.toDto(courseRepo.findById(id).orElseThrow());
    }

    @Override
    public Collection<CourseDto> getCoursesByCategoryLike(String categoryLike) {
        return courseMapper.toDtoList(courseRepo.findByCategoryLike(categoryLike));
    }

    @Override
    public Collection<CourseDto> getCoursesWithEditions() {
        return courseMapper.toDtoList(courseRepo.findByCoursesWithEditions());
    }

    /**
     * Delete course
     *
     * @param id
     */
    @Override
    public void deleteCourse(long id) {
        courseRepo.deleteById(id);
    }

    /**
     * Create a new course
     *
     * @param course
     * @return
     */
    @Override
    public CourseDto saveCourse(CourseDto course) {
        var saved = courseRepo.save(courseMapper.toEntity(course));
        return courseMapper.toDto(saved);
    }

    @Override
    public CourseDto updateCourse(CourseDto courseDto) {
        courseRepo.findById(courseDto.getId()).orElseThrow();

        var updatedCourse = courseRepo.save(courseMapper.toEntity(courseDto));

        return courseMapper.toDto(updatedCourse);
    }

    @Override
    public Collection<CourseEditionPresentation> getFilteredCoursesWithMostRecentEdition(CourseFilter filter) {
        var filteredCourses = getFiltered(filter);
        var coursesWithMostRecentEdition = courseEditionService.getMostRecentEdition(filteredCourses);
        return courseMapper.toCourseEditionPresentation(coursesWithMostRecentEdition);
    }

    @Override
    public Collection<CourseDto> getFiltered(CourseFilter courseFilter) {
        return courseFilter == null ? courseMapper.toDtoList(courseRepo.findAll()) :
                courseMapper.toDtoList(courseRepo.findAll(CourseSpecification.getCourseFilterConditions(courseFilter)));
    }

}
