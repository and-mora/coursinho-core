package it.amorabito.coursinho.services.implementations;

import it.amorabito.coursinho.model.dtos.CourseEditionDto;
import it.amorabito.coursinho.model.entities.Course;
import it.amorabito.coursinho.model.entities.CourseEdition;
import it.amorabito.coursinho.model.mapper.CourseEditionMapper;
import it.amorabito.coursinho.repositories.CourseEditionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class CourseEditionServiceTest {

    long ID_DEFAULT = 10L;
    Course course;
    CourseEdition courseEdition;

    @Spy
    CourseEditionMapper courseEditionMapper = Mappers.getMapper(CourseEditionMapper.class);
    @Mock
    private CourseEditionRepository courseEditionRepo;
//    @Mock
//    private CourseRepository courseRepo;
//    @Mock
//    private ModuleRepository moduleRepo;

    @InjectMocks
    private CourseEditionServiceImpl courseEditionService;

    @BeforeEach
    void init() {
//        courseEditionService = new CourseEditionServiceImpl(courseEditionRepo, null, null,
//                null, null,null,courseEditionMapper, null);
        course = createCourse();
        courseEdition = createEdition(course);
    }

    @Test
    void whenCourseEditionIsNotFoundThrowsException() {
        doReturn(Optional.empty()).when(courseEditionRepo).findById(any());

        assertThatThrownBy(() -> courseEditionService.getCourseEditionById(ID_DEFAULT)).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void whenCourseEditionIsFoundReturnsDto() {
        doReturn(Optional.of(courseEdition)).when(courseEditionRepo).findById(any());

        var courseEdition = courseEditionService.getCourseEditionById(ID_DEFAULT);

        assertThat(courseEdition)
                .isInstanceOf(CourseEditionDto.class)
                .extracting("id", "courseId")
                .contains(ID_DEFAULT, course.getId());
    }


    /*@Test
    public void getByCourse() {
    }

    @Test
    public void getModulesByIdTest() {
*/

    private Course createCourse() {
        Course c = new Course();
        c.setPrice(100);
        c.setCategory("catTest");
        c.setName("nameTest");
        return c;
    }

    private CourseEdition createEdition(Course c) {
        CourseEdition ce = new CourseEdition();
        ce.setId(ID_DEFAULT);
        ce.setCourse(c);

        return ce;
    }

}
