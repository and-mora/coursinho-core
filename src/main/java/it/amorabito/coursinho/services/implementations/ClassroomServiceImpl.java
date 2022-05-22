package it.amorabito.coursinho.services.implementations;

import it.amorabito.coursinho.model.dtos.ClassroomDto;
import it.amorabito.coursinho.model.mapper.ClassroomMapper;
import it.amorabito.coursinho.repositories.ClassroomRepository;
import it.amorabito.coursinho.repositories.RealClassroomRepository;
import it.amorabito.coursinho.repositories.VirtualClassroomRepository;
import it.amorabito.coursinho.services.abstractions.ClassroomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Transactional
@RequiredArgsConstructor
public class ClassroomServiceImpl implements ClassroomService {

    private final ClassroomRepository classroomRepo;
    private final RealClassroomRepository realClassroomRepo;
    private final VirtualClassroomRepository virtualClassroomRepo;
    private final ClassroomMapper classroomMapper;

    @Override
    public Collection<ClassroomDto> getAllClassrooms() {
        return classroomMapper.toDtoList(classroomRepo.findAll());
    }

    @Override
    public ClassroomDto getClassroomById(long id) {
        return classroomMapper.toDto(classroomRepo.findById(id).orElseThrow());
    }

    @Override
    public Collection<ClassroomDto> getRealClassrooms() {
        return classroomMapper.fromRealToDtoList(realClassroomRepo.findAll());
    }

    @Override
    public Collection<ClassroomDto> getVirtualClassrooms() {
        return classroomMapper.fromVirtualToDtoList(virtualClassroomRepo.findAll());
    }
}
