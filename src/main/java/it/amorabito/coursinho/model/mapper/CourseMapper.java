package it.amorabito.coursinho.model.mapper;

import it.amorabito.coursinho.model.dtos.ApplicationDto;
import it.amorabito.coursinho.model.dtos.CourseDto;
import it.amorabito.coursinho.model.entities.Course;
import org.mapstruct.Mapper;

@Mapper
public interface CourseMapper {
    Course toEntity(CourseDto courseDto);

    ApplicationDto toDto(Course course);
}
