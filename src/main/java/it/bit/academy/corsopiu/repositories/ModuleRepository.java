package it.bit.academy.corsopiu.repositories;

import it.bit.academy.corsopiu.entities.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface ModuleRepository extends JpaRepository<Module, Long> {

    @Query("select m from Module as m where m.edition_id = :editionId")
    Collection<Module> getByCouseEditionId(Long editionId);
}
