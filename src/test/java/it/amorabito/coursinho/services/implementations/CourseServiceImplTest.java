package it.amorabito.coursinho.services.implementations;

import it.amorabito.coursinho.repositories.CourseRepository;
import it.amorabito.coursinho.services.abstractions.CourseService;
import org.mockito.InjectMocks;
import org.mockito.Mock;

// todo is this a JPA test?
class CourseServiceImplTest {

    @Mock
    CourseRepository courseRepo;

    @InjectMocks
    CourseService courseService;

//    @Test
//    void whenNoCourseMatchCriteriaReturnsNone() {
//    }

}