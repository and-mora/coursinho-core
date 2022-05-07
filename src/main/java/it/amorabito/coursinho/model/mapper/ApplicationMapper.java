package it.amorabito.coursinho.model.mapper;

import it.amorabito.coursinho.model.dtos.ApplicationDto;
import it.amorabito.coursinho.model.entities.Application;
import org.mapstruct.Mapper;

@Mapper
public interface ApplicationMapper {
    Application toEntity(ApplicationDto applicationDto);

    ApplicationDto toDto(Application application);
}
