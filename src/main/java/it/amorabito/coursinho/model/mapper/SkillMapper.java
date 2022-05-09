package it.amorabito.coursinho.model.mapper;

import it.amorabito.coursinho.model.dtos.SkillDto;
import it.amorabito.coursinho.model.entities.Skill;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SkillMapper {
    Skill toEntity(SkillDto skillDto);

    SkillDto toDto(Skill skill);
}
