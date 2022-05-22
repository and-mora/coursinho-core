package it.amorabito.coursinho.model.dtos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationDtoTest {

    @Test
    void compareApplications() {
        var firstApp = new ApplicationDto();
        firstApp.setId(0);
        firstApp.setComments("ciao");

        var secondApp = new ApplicationDto();
        secondApp.setId(0);
        secondApp.setComments("no");

        assertEquals(firstApp, secondApp);
    }
}