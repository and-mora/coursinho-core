package it.amorabito.coursinho.services.implementations;

import it.amorabito.coursinho.model.entities.Application;
import it.amorabito.coursinho.model.entities.CourseEdition;
import it.amorabito.coursinho.model.entities.Student;
import it.amorabito.coursinho.exceptions.EntityNotFoundException;
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

    @Override
    public Collection<Application> getByEdition(long editionId) throws EntityNotFoundException {
        Optional<CourseEdition> opt = this.courseEditionRepo.findById(editionId);

        if (opt.isEmpty()) {
            throw new EntityNotFoundException("course edition con id " + editionId + " non trovato.");
        }

        return this.applicationRepo.findByEdition(opt.get());
    }

    @Override
    public Collection<Application> getByStudent(long studentId) throws EntityNotFoundException {
        Optional<Student> opt = this.studentRepo.findById(studentId);

        if (opt.isEmpty()) {
            throw new EntityNotFoundException("studente con id " + studentId + " non trovato.");
        }

        return this.applicationRepo.findByStudent(opt.get());
    }

    @Override
    public Application save(Application application) throws EntityNotFoundException {
        // controllo che l'edizione e lo studente esistano
        Optional<Student> optStu = this.studentRepo.findById(application.getStudent().getId());

        if (optStu.isEmpty()) {
            throw new EntityNotFoundException("studente con id " + application.getStudent().getId() + " non trovato.");
        }

        Optional<CourseEdition> optEd = this.courseEditionRepo.findById(application.getEdition().getId());
        if (optEd.isEmpty()) {
            throw new EntityNotFoundException("edizione con id " + application.getEdition().getId() + " non trovato.");
        }

        application.setEdition(optEd.get());
        application.setStudent(optStu.get());

        return applicationRepo.save(application);
    }


}
