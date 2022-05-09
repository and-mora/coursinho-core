package it.amorabito.coursinho.model.mapper;

import it.amorabito.coursinho.model.dtos.WeeklySessionDto;
import it.amorabito.coursinho.model.entities.WeeklySession;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WeeklySessionMapper {
    WeeklySession toEntity(WeeklySessionDto weeklySessionDto);

    WeeklySessionDto toDto(WeeklySession weeklySession);
}
