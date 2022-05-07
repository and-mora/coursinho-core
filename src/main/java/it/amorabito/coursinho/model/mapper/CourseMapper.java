package it.amorabito.coursinho.model.mapper;

import it.amorabito.coursinho.model.dtos.CourseDto;
import it.amorabito.coursinho.model.entities.Course;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper
public interface CourseMapper {
    Course toEntity(CourseDto courseDto);

    Collection<Course> toEntityList(Collection<CourseDto> courseDtos);

    CourseDto toDto(Course course);

    Collection<CourseDto> toDtoList(Collection<Course> courses);
}
