package it.amorabito.coursinho.services.abstractions;

import it.amorabito.coursinho.entities.Classroom;
import it.amorabito.coursinho.entities.RealClassroom;
import it.amorabito.coursinho.entities.VirtualClassroom;

import java.util.Collection;
import java.util.Optional;

public interface ClassroomService {

    Collection<Classroom> getAllClassrooms();

    Optional<Classroom> getClassroomById(long id);

    Collection<RealClassroom> getRealClassrooms();

    Collection<VirtualClassroom> getVirtualClassrooms();
}
