package it.bit.academy.corsopiu.repositories;

import it.bit.academy.corsopiu.dtos.CategoryData;
import it.bit.academy.corsopiu.entities.Course;
import it.bit.academy.corsopiu.entities.CourseEdition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("select new it.bit.academy.corsopiu.dtos.CategoryData(c.category, count(*)) " +
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

    // DA TESTARE!
//    @Query("select c from Course as c where c.category like :categoryLike ")
//    Page<Collection<Course>> findByCategoryLikePaged(String categoryLike, Pageable pageable);

    Collection<Course> findByCategoryLike(String categoryLike);

    // OBSOLETO
//    Collection<Course> findByPriceGreaterThanEqualAndPriceLessThanEqual(double minPrice, double maxPrice);

    Optional<CourseEdition> findFirstByEditions(Course course);
}
