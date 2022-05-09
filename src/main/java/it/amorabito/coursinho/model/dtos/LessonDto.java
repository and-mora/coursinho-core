package it.amorabito.coursinho.model.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class LessonDto {

    @EqualsAndHashCode.Include
    private long id;
    private String subject;
    private LocalDateTime start;
    private LocalDateTime end;
    private long teacherId;
    private String teacherName;
    private long classroomId;
    private String classroomName;
    private long moduleId;
}
