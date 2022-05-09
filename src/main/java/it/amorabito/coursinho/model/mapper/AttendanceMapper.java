package it.amorabito.coursinho.model.mapper;

import it.amorabito.coursinho.model.dtos.AttendanceDto;
import it.amorabito.coursinho.model.entities.Attendance;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AttendanceMapper {
    Attendance toEntity(AttendanceDto attendanceDto);

    AttendanceDto toDto(Attendance attendance);
}
