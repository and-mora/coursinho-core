package it.amorabito.coursinho.model.mapper;

import it.amorabito.coursinho.model.dtos.LessonDto;
import it.amorabito.coursinho.model.entities.Lesson;
import org.mapstruct.Mapper;

@Mapper
public interface LessonMapper {
    Lesson toEntity(LessonDto lessonDto);

    LessonDto toDto(Lesson lesson);
}
