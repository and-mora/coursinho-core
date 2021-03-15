package it.bit.academy.corsopiu.services.abstractions;

import it.bit.academy.corsopiu.entities.Classroom;
import it.bit.academy.corsopiu.entities.RealClassroom;
import it.bit.academy.corsopiu.entities.VirtualClassroom;

import java.util.Collection;
import java.util.Optional;

public interface ClassroomService {

    Collection<Classroom> getAllClassrooms();

    Optional<Classroom> getClassroomById(long id);

    Collection<RealClassroom> getRealClassrooms();

    Collection<VirtualClassroom> getVirtualClassrooms();
}
