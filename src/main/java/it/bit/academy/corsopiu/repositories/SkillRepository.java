package it.bit.academy.corsopiu.repositories;

import it.bit.academy.corsopiu.entities.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long> {
}
