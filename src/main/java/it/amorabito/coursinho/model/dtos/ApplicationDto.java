package it.amorabito.coursinho.model.dtos;

import it.amorabito.coursinho.model.entities.ProcessingState;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ApplicationDto {

    @EqualsAndHashCode.Include
    private long id;
    private String comments;
    private LocalDateTime applicationDate;
    private ProcessingState applicationState;
    private long editionId;
    private long studentId;
    private String studentName;
}
