package it.bit.academy.corsopiu.services.abstractions;

import it.bit.academy.corsopiu.entities.Application;
import it.bit.academy.corsopiu.exceptions.EntityNotFoundException;

import java.util.Collection;

public interface ApplicationService {

    Collection<Application> getApplicationsByEdition(long editionId) throws EntityNotFoundException;

    Application save(Application application) throws EntityNotFoundException;
}
