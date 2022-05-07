package it.amorabito.coursinho.model.mapper;

import it.amorabito.coursinho.model.dtos.ModuleDto;
import it.amorabito.coursinho.model.entities.Module;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper
public interface ModuleMapper {
    Module toEntity(ModuleDto moduleDto);

    Collection<Module> toEntityList(Collection<ModuleDto> moduleDtos);

    ModuleDto toDto(Module module);

    Collection<ModuleDto> toDtoList(Collection<Module> modules);

}
