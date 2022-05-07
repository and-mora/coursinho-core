package it.amorabito.coursinho.model.mapper;

import it.amorabito.coursinho.model.dtos.CourseEditionDto;
import it.amorabito.coursinho.model.entities.CourseEdition;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper
public interface CourseEditionMapper {
    CourseEdition toEntity(CourseEditionDto courseEditionDto);

    Collection<CourseEdition> toEntityList(Collection<CourseEditionDto> courseEditionDtos);

    CourseEditionDto toDto(CourseEdition courseEdition);

    Collection<CourseEditionDto> toDtoList(Collection<CourseEdition> courseEditions);
}
