package it.amorabito.coursinho.controllers;

import it.amorabito.coursinho.model.dtos.CourseEditionDto;
import it.amorabito.coursinho.services.abstractions.CourseEditionService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration(classes = {CourseEditionController.class, CourseEditionService.class})
@WebMvcTest
@Slf4j
class CourseEditionControllerTest {

    long ID_DEFAULT = 10L;

    @MockBean
    CourseEditionService courseEditionService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void whenCourseEditionIsFoundReturn200() throws Exception {
        doReturn(new CourseEditionDto()).when(courseEditionService).getCourseEditionById(ID_DEFAULT);

        MvcResult result = mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/course-edition/{id}", ID_DEFAULT))
                .andExpect(status().isOk())
                .andReturn();
    }

//    @Test
//    void whenCourseEditionIsNotFoundReturn404() throws Exception {
//        doThrow(new NoSuchElementException()).when(courseEditionService).getCourseEditionById(ID_DEFAULT);
//
//        MvcResult result = mockMvc.perform(
//                        MockMvcRequestBuilders.get("/api/course-edition/{id}", ID_DEFAULT))
//                .andExpect(status().isNotFound())
//                .andReturn();
//    }
}