package it.amorabito.coursinho.services.abstractions;

import it.amorabito.coursinho.model.dtos.ClassroomDto;

import java.util.Collection;

public interface ClassroomService {

    Collection<ClassroomDto> getAllClassrooms();

    ClassroomDto getClassroomById(long id);

    Collection<ClassroomDto> getRealClassrooms();

    Collection<ClassroomDto> getVirtualClassrooms();
}
