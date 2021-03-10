package it.bit.academy.corsopiu.repositories;

import it.bit.academy.corsopiu.entities.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface ModuleRepository extends JpaRepository<Module, Long> {

    // TO FIX
    @Query("select m from Module as m where m.edition.getId() = :editionId")
    Collection<Module> getByCouseEditionId(@Param("editionId") Long editionId);
}
