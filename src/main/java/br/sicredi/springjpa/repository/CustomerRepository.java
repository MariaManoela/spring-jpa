package br.sicredi.springjpa.repository;

import br.sicredi.springjpa.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface CustomerRepository extends CrudRepository<Customer, Long> {
   Optional<Customer> findById(@Param("id")Long id);
   Customer findByLastName(String lastName);
}
