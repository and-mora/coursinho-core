package it.amorabito.coursinho.model.dtos;

import it.amorabito.coursinho.model.entities.DayWeek;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class WeeklySessionDto {

    @EqualsAndHashCode.Include
    private long id;
    private DayWeek day;
    private String start;
    private String end;
    private long editionId;
}
