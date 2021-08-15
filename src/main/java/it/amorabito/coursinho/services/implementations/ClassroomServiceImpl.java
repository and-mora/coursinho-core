package it.amorabito.coursinho.services.implementations;

import it.amorabito.coursinho.entities.Classroom;
import it.amorabito.coursinho.entities.RealClassroom;
import it.amorabito.coursinho.entities.VirtualClassroom;
import it.amorabito.coursinho.repositories.ClassroomRepository;
import it.amorabito.coursinho.repositories.RealClassroomRepository;
import it.amorabito.coursinho.repositories.VirtualClassroomRepository;
import it.amorabito.coursinho.services.abstractions.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

@Service
@Transactional
public class ClassroomServiceImpl implements ClassroomService {

    private ClassroomRepository classroomRepo;
    private RealClassroomRepository realClassroomRepo;
    private VirtualClassroomRepository virtualClassroomRepo;

    @Autowired
    public ClassroomServiceImpl(ClassroomRepository classroomRepo,
                                RealClassroomRepository realClassroomRepo,
                                VirtualClassroomRepository virtualClassroomRepo) {
        this.classroomRepo = classroomRepo;
        this.realClassroomRepo = realClassroomRepo;
        this.virtualClassroomRepo = virtualClassroomRepo;
    }

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
