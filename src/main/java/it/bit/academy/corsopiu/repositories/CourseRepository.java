package it.bit.academy.corsopiu.repositories;

import it.bit.academy.corsopiu.dtos.CategoryData;
import it.bit.academy.corsopiu.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("select new it.bit.academy.corsopiu.dtos.CategoryData(c.category, count(*)) " +
            "from Course as c " +
            "group by c.category " +
            "order by count(*) desc")
    List<CategoryData> getCategoriesCount();
}
