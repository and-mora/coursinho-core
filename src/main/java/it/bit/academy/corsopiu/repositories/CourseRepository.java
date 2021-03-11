package it.bit.academy.corsopiu.repositories;

import it.bit.academy.corsopiu.dtos.CategoryData;
import it.bit.academy.corsopiu.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("select new it.bit.academy.corsopiu.dtos.CategoryData(c.category, count(*)) " +
            "from Course as c " +
            "group by c.category " +
            "order by count(*) desc")
    List<CategoryData> getCategoriesCount();

    @Query("select max(c.price) from Course as c")
    Double getMaxPrice();

    @Query("select min(c.price) from Course as c")
    Double getMinPrice();

    @Query("select ce.course from CourseEdition as  ce ")
    Collection<Course> limit();

//    @Query("select c from Course as c where c.category like :categoryLike ")
    Collection<Course> findByCategoryLike(String categoryLike);

    Collection<Course> findByPriceGreaterThanEqualAndPriceLessThanEqual(double minPrice, double maxPrice);
}
