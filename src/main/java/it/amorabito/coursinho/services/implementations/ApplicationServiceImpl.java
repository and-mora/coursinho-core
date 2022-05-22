package it.amorabito.coursinho.services.implementations;

import it.amorabito.coursinho.exceptions.EntityNotFoundException;
import it.amorabito.coursinho.model.dtos.ApplicationDto;
import it.amorabito.coursinho.model.entities.CourseEdition;
import it.amorabito.coursinho.model.entities.Student;
import it.amorabito.coursinho.model.mapper.ApplicationMapper;
import it.amorabito.coursinho.repositories.ApplicationRepository;
import it.amorabito.coursinho.repositories.CourseEditionRepository;
import it.amorabito.coursinho.repositories.StudentRepository;
import it.amorabito.coursinho.services.abstractions.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepo;
    private final CourseEditionRepository courseEditionRepo;
    private final StudentRepository studentRepo;
    private final ApplicationMapper applicationMapper;

    @Override
    public Collection<ApplicationDto> getByEdition(long editionId) throws EntityNotFoundException {
        Optional<CourseEdition> opt = this.courseEditionRepo.findById(editionId);

        if (opt.isEmpty()) {
            throw new EntityNotFoundException("course edition con id " + editionId + " non trovato.");
        }

        return applicationMapper.toDtoList(applicationRepo.findByEdition(opt.get()));
    }

    @Override
    public Collection<ApplicationDto> getByStudent(long studentId) throws EntityNotFoundException {
        Optional<Student> opt = this.studentRepo.findById(studentId);

        if (opt.isEmpty()) {
            throw new EntityNotFoundException("studente con id " + studentId + " non trovato.");
        }

        return applicationMapper.toDtoList(applicationRepo.findByStudent(opt.get()));
    }

    @Override
    public ApplicationDto save(ApplicationDto application) throws EntityNotFoundException {
        // controllo che l'edizione e lo studente esistano
        Optional<Student> optStu = this.studentRepo.findById(application.getStudentId());

        if (optStu.isEmpty()) {
            throw new EntityNotFoundException("studente con id " + application.getStudentId() + " non trovato.");
        }

        Optional<CourseEdition> optEd = this.courseEditionRepo.findById(application.getEditionId());
        if (optEd.isEmpty()) {
            throw new EntityNotFoundException("edizione con id " + application.getEditionId() + " non trovato.");
        }

        var applicationSaved = applicationRepo.save(applicationMapper.toEntity(application));

        return applicationMapper.toDto(applicationSaved);
    }


}
