package it.amorabito.coursinho.services.implementations;

import it.amorabito.coursinho.model.entities.Classroom;
import it.amorabito.coursinho.model.entities.RealClassroom;
import it.amorabito.coursinho.model.entities.VirtualClassroom;
import it.amorabito.coursinho.repositories.ClassroomRepository;
import it.amorabito.coursinho.repositories.RealClassroomRepository;
import it.amorabito.coursinho.repositories.VirtualClassroomRepository;
import it.amorabito.coursinho.services.abstractions.ClassroomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ClassroomServiceImpl implements ClassroomService {

    private final ClassroomRepository classroomRepo;
    private final RealClassroomRepository realClassroomRepo;
    private final VirtualClassroomRepository virtualClassroomRepo;

    @Override
    public Collection<Classroom> getAllClassrooms() {
        return this.classroomRepo.findAll();
    }

    @Override
    public Optional<Classroom> getClassroomById(long id) {
        return this.classroomRepo.findById(id);
    }

    @Override
    public Collection<RealClassroom> getRealClassrooms() {
        return this.realClassroomRepo.findAll();
    }

    @Override
    public Collection<VirtualClassroom> getVirtualClassrooms() {
        return this.virtualClassroomRepo.findAll();
    }
}
