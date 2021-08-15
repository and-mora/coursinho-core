package it.amorabito.coursinho.services.abstractions;

import it.amorabito.coursinho.exceptions.EntityNotFoundException;
import it.amorabito.coursinho.entities.Application;

import java.util.Collection;

public interface ApplicationService {

    Collection<Application> getByEdition(long editionId) throws EntityNotFoundException;

    Collection<Application> getByStudent(long studentId) throws EntityNotFoundException;

    Application save(Application application) throws EntityNotFoundException;
}
