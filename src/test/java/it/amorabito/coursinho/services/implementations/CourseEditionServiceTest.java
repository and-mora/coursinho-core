package it.amorabito.coursinho.services.implementations;

import it.amorabito.coursinho.model.entities.Course;
import it.amorabito.coursinho.model.entities.CourseEdition;
import it.amorabito.coursinho.model.entities.Module;
import it.amorabito.coursinho.exceptions.EntityNotFoundException;
import it.amorabito.coursinho.services.abstractions.CourseEditionService;
import it.amorabito.coursinho.repositories.CourseEditionRepository;
import it.amorabito.coursinho.repositories.CourseRepository;
import it.amorabito.coursinho.repositories.ModuleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CourseEditionServiceTest {

    @Autowired
    private CourseEditionRepository courseEditionRepo;
    @Autowired
    private CourseRepository courseRepo;
    @Autowired
    private ModuleRepository moduleRepo;

    @Autowired
    private CourseEditionService courseEditionService;

    @Test
    public void getByCourse() throws EntityNotFoundException {
        // create course
        Course c = createCourse();
        Course saved = this.courseRepo.save(c);
        // create edition
        CourseEdition ce = createEdition(saved);
        ce.setDescription("1st ed");
        this.courseEditionRepo.save(ce);
        // create 2nd edition
        CourseEdition ce2 = createEdition(c);
        ce2.setDescription("2nd ed");
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

    @Test
    public void getModulesByIdTest() {
        // create course
        Course c = createCourse();
        Course cSaved = this.courseRepo.save(c);
        // create edition
        CourseEdition ce = createEdition(cSaved);
        ce.setDescription("1st ed");
        CourseEdition ceSaved = this.courseEditionRepo.save(ce);
        // create modules
        Module m = new Module();
        m.setEdition(ceSaved);
        m.setDescription("descrTest");
        m.setName("nameTest");
        Module mSaved = this.moduleRepo.save(m);

        // run test
        List<Module> results = (List<Module>) this.courseEditionService.getModuleByCourseEditionId(ceSaved.getId());

        // check
        Assertions.assertTrue(results.size() > 0);
        Assertions.assertTrue(results.stream().anyMatch(module -> module.getName().equals("nameTest")));

        // delete modules
        this.moduleRepo.delete(mSaved);
        // delete edition
        this.courseEditionRepo.delete(ceSaved);
        // delete course
        this.courseRepo.delete(cSaved);
    }

    private Course createCourse() {
        Course c = new Course();
        c.setPrice(100);
        c.setCategory("catTest");
        c.setName("nameTest");
        return c;
    }

    private CourseEdition createEdition(Course c) {
        CourseEdition ce = new CourseEdition();
        ce.setCourse(c);

        return ce;
    }

}
