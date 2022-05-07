package it.amorabito.coursinho.model.mapper;

import it.amorabito.coursinho.model.dtos.ModuleDto;
import org.mapstruct.Mapper;

@Mapper
public interface ModuleMapper {
    Module toEntity(ModuleDto moduleDto);

    ModuleDto toDto(Module module);
}
