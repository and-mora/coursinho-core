package it.amorabito.coursinho.repositories;

import it.amorabito.coursinho.model.dtos.CategoryData;
import it.amorabito.coursinho.model.entities.Course;
import it.amorabito.coursinho.model.entities.CourseEdition;
import it.amorabito.coursinho.repositories.custom.CourseRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long>, CourseRepositoryCustom {

    @Query("select new it.amorabito.coursinho.model.dtos.CategoryData(c.category, count(*)) " +
            "from Course as c " +
            "group by c.category " +
            "order by count(*) desc")
    List<CategoryData> findByCategoriesCount();

    @Query("select max(c.price) from Course as c")
    Double findByMaxPrice();

    @Query("select min(c.price) from Course as c")
    Double findByMinPrice();

    @Query("select distinct ce.course from CourseEdition as ce ")
    Collection<Course> findByCoursesWithEditions();

    @Query("select distinct ce.course from CourseEdition as ce where ce.course.price >= :minPrice and ce.course.price <= :maxPrice")
    Collection<Course> findByCoursesWithEditionsByPrices(double minPrice, double maxPrice);

    Collection<Course> findByCategoryLike(String categoryLike);

    Optional<CourseEdition> findFirstByEditions(Course course);
}
