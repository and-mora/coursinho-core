package it.amorabito.coursinho.model.mapper;

import it.amorabito.coursinho.model.entities.Classroom;
import org.mapstruct.Mapper;

@Mapper
public interface ClassroomDto {
    Classroom toEntity(ClassroomDto classroomDto);

    ClassroomDto toDto(Classroom classroom);
}
