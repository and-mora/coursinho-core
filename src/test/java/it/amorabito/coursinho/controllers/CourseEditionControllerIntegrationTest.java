package it.amorabito.coursinho.controllers;

import it.amorabito.coursinho.model.dtos.CourseEditionDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith({SpringExtension.class})
class CourseEditionControllerIntegrationTest {

    @LocalServerPort
    private int port;
    private String baseUrl = "http://localhost";

    @Autowired
    private static TestRestTemplate restTemplate;

    @BeforeAll
    static void init() {
        restTemplate = new TestRestTemplate();
    }

    @BeforeEach
    void setup() {
        baseUrl = baseUrl.concat(":").concat(port + "").concat("/api/course-edition");
    }


    @Test
    @Sql(statements = "INSERT INTO course_edition (id, description) VALUES (10, 'sample edition')",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements = "DELETE FROM course_edition",
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void whenGetEditionById_return200() {
        var responseEntity = restTemplate.getForEntity(baseUrl.concat("/{id}"),
                CourseEditionDto.class, 10);

        assertThat(responseEntity).isNotNull();
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isNotNull();
        assertThat(responseEntity.getBody().getDescription()).isEqualTo("sample edition");
    }

//    @Test
//    @Sql(statements = "INSERT INTO course_edition (id, description) VALUES (10, 'sample edition')",
//            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
//    @Sql(statements = "DELETE FROM course_edition",
//            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
//    void whenGetEditionById_return404() {
//        var responseEntity = restTemplate.getForEntity(baseUrl.concat("/{id}"),
//                CourseEditionDto.class, 20);
//
//        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
//        assertThat(responseEntity.getBody()).isNull();
//    }
}
