package it.amorabito.coursinho.model.mapper;

import it.amorabito.coursinho.model.dtos.CourseEditionDto;
import it.amorabito.coursinho.model.entities.CourseEdition;
import org.mapstruct.Mapper;

@Mapper
public interface CourseEditionMapper {
    CourseEdition toEntity(CourseEditionDto courseEditionDto);

    CourseEditionDto toDto(CourseEdition courseEdition);
}
