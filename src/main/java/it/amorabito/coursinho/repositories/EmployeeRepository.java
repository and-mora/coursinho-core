package it.amorabito.coursinho.repositories;

import it.amorabito.coursinho.model.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
