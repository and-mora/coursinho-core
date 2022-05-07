package it.amorabito.coursinho.model.mapper;

import it.amorabito.coursinho.model.dtos.PersonDto;
import it.amorabito.coursinho.model.entities.Person;
import org.mapstruct.Mapper;

@Mapper
public interface PersonMapper {
    Person toEntity(PersonDto personDto);

    PersonDto toDto(Person person);
}
