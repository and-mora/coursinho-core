package it.amorabito.coursinho.services.abstractions;

import it.amorabito.coursinho.exceptions.EntityNotFoundException;
import it.amorabito.coursinho.model.dtos.ApplicationDto;

import java.util.Collection;

public interface ApplicationService {

    Collection<ApplicationDto> getByEdition(long editionId) throws EntityNotFoundException;

    Collection<ApplicationDto> getByStudent(long studentId) throws EntityNotFoundException;

    ApplicationDto save(ApplicationDto application) throws EntityNotFoundException;
}
