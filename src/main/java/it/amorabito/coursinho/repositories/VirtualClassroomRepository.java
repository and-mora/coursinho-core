package it.amorabito.coursinho.repositories;

import it.amorabito.coursinho.model.entities.VirtualClassroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VirtualClassroomRepository extends JpaRepository<VirtualClassroom, Long> {
}
