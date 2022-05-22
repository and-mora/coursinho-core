package it.amorabito.coursinho.model.mapper;

import it.amorabito.coursinho.model.dtos.ClassroomDto;
import it.amorabito.coursinho.model.entities.Classroom;
import it.amorabito.coursinho.model.entities.RealClassroom;
import it.amorabito.coursinho.model.entities.VirtualClassroom;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface ClassroomMapper {

    ClassroomDto toDto(Classroom classroom);

    Collection<ClassroomDto> toDtoList(Collection<Classroom> classrooms);

    ClassroomDto fromRealToDto(RealClassroom realClassroom);

    Collection<ClassroomDto> fromRealToDtoList(Collection<RealClassroom> realClassrooms);

    ClassroomDto fromVirtualToDto(VirtualClassroom virtualClassroom);

    Collection<ClassroomDto> fromVirtualToDtoList(Collection<VirtualClassroom> virtualClassrooms);
}
