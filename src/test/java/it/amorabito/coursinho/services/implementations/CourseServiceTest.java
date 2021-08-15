package it.amorabito.coursinho.services.implementations;

import it.amorabito.coursinho.entities.Course;
import it.amorabito.coursinho.services.abstractions.CourseService;
import it.amorabito.coursinho.repositories.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CourseServiceTest {

    @Autowired
    CourseRepository courseRepo;

    @Autowired
    CourseService courseService;

    @Test
    public void getCourseByIdTest() {
        // creo un corso di prova e lo salvo tramite repo
        Course c = new Course();
        c.setName("provaTest");
        Course saved = this.courseRepo.save(c);

        // metodo del service da testare
        Optional<Course> opt = this.courseService.getCourseById(saved.getId());

        assertTrue(opt.isPresent());
        assertEquals("provaTest", opt.get().getName());

        // elimino il corso di prova dopo averlo testato
        this.courseRepo.delete(c);
    }

    @Test
    public void getCourseByCategoryLikeTest() {
        String stringTest = "Ciccio";
        Course c = new Course();
        c.setCategory(stringTest);
        this.courseRepo.save(c);

        Collection<Course> lista = this.courseService.getCoursesByCategoryLike(stringTest);

        assertTrue(lista.size() > 0);
        assertEquals(stringTest, lista.iterator().next().getCategory());

        this.courseRepo.delete(c);
    }

//    @Test
//    public void getCourseBetweenPrices() {
//        double minPrice = -100;
//        double maxPrice = -50;
//        double media = (maxPrice+minPrice)/2;
//        Course c = new Course();
//        c.setPrice(media);
//        this.courseRepo.save(c);
//
//        Collection<Course> lista = this.courseService.getCoursesBetweenPrices(minPrice, maxPrice);
//
//        assertTrue(lista.size() > 0);
//
//        this.courseRepo.delete(c);
//    }
}
