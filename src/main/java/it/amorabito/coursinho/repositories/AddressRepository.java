package it.amorabito.coursinho.repositories;

import it.amorabito.coursinho.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
