package it.amorabito.coursinho.repositories;

import it.amorabito.coursinho.entities.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface ModuleRepository extends JpaRepository<Module, Long> {

    @Query("select m from Module as m where m.edition.id = :editionId")
    Collection<Module> getByCouseEditionId(@Param("editionId") Long editionId);
}
