package it.bit.academy.corsopiu.services.abstractions;

import it.bit.academy.corsopiu.entities.Application;
import it.bit.academy.corsopiu.exceptions.EntityNotFoundException;

public interface ApplicationService {

    Application saveApplication(Application application) throws EntityNotFoundException;
}
