package it.bit.academy.corsopiu.repositories;

import it.bit.academy.corsopiu.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
