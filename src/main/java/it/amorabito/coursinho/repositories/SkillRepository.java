package it.amorabito.coursinho.repositories;

import it.amorabito.coursinho.entities.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long> {
}
