package it.amorabito.coursinho.model.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CourseEditionDto {

    @EqualsAndHashCode.Include
    private long id;
    private LocalDate startDate;
    private long classroomId;
    private String classroomName;
    private String description;
    private long tutorId;
    private String tutorName;
    private long courseId;
}
