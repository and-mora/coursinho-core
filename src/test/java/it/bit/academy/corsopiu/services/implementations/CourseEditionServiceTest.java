package it.bit.academy.corsopiu.services.implementations;

import it.bit.academy.corsopiu.entities.Course;
import it.bit.academy.corsopiu.entities.CourseEdition;
import it.bit.academy.corsopiu.exceptions.EntityNotFoundException;
import it.bit.academy.corsopiu.repositories.CourseEditionRepository;
import it.bit.academy.corsopiu.repositories.CourseRepository;
import it.bit.academy.corsopiu.services.abstractions.CourseEditionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
public class CourseEditionServiceTest {

    @Autowired
    private CourseEditionRepository courseEditionRepo;
    @Autowired
    private CourseRepository courseRepo;

    @Autowired
    private CourseEditionService courseEditionService;

    @Test
    public void getByCourse() throws EntityNotFoundException {
        // create course
        Course c = new Course();
        Course saved = this.courseRepo.save(c);
        // create edition
        CourseEdition ce = new CourseEdition();
        ce.setDescription("1st ed");
        ce.setCourse(saved);
        this.courseEditionRepo.save(ce);
        // create 2nd edition
        CourseEdition ce2 = new CourseEdition();
        ce2.setDescription("2nd ed");
        ce2.setCourse(saved);
        this.courseEditionRepo.save(ce2);

        // run test
        List<CourseEdition> results =  new ArrayList<>(this.courseEditionService.getByCourse(saved.getId()));

        //check results
        Assertions.assertEquals(2, results.size());
        Assertions.assertTrue(results.stream().anyMatch(ed -> ed.getDescription().equals("1st ed")));

        // delete editions
        this.courseEditionRepo.delete(ce2);
        this.courseEditionRepo.delete(ce);
        // delete course
        this.courseRepo.delete(saved);
    }

}
