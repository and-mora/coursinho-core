package it.bit.academy.corsopiu.repositories;

import it.bit.academy.corsopiu.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
