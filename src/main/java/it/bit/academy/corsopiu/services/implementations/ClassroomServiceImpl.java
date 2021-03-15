package it.bit.academy.corsopiu.services.implementations;

import it.bit.academy.corsopiu.entities.Classroom;
import it.bit.academy.corsopiu.entities.RealClassroom;
import it.bit.academy.corsopiu.entities.VirtualClassroom;
import it.bit.academy.corsopiu.repositories.ClassroomRepository;
import it.bit.academy.corsopiu.repositories.RealClassroomRepository;
import it.bit.academy.corsopiu.repositories.VirtualClassroomRepository;
import it.bit.academy.corsopiu.services.abstractions.ClassroomService;
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
