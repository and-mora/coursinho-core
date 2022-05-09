package it.amorabito.coursinho.model.mapper;

import it.amorabito.coursinho.model.dtos.ApplicationDto;
import it.amorabito.coursinho.model.entities.Application;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface ApplicationMapper {
    Application toEntity(ApplicationDto applicationDto);

    Collection<Application> toEntityList(Collection<ApplicationDto> applicationDtos);

    ApplicationDto toDto(Application application);

    Collection<ApplicationDto> toDtoList(Collection<Application> applications);

}
