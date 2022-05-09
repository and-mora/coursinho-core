package it.amorabito.coursinho.model.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AttendanceDto {

    @EqualsAndHashCode.Include
    private long id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private long studentId;
    private long lessonId;
}
