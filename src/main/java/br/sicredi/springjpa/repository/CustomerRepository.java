package br.sicredi.springjpa.repository;

import br.sicredi.springjpa.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
   Optional<Customer> findById(Long id);
   List<Customer> findByLastName(String lastName);
}
