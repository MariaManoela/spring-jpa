package br.sicredi.springjpa.service;

import br.sicredi.springjpa.model.Customer;
import br.sicredi.springjpa.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    CustomerRepository repository;

    public List<Customer> findAll(){
        return (List<Customer>) repository.findAll();
    }

    public Optional<Customer> findById(Long id) {
        return repository.findById(id);
    }

    public Customer findByLastName(String lastName) {
        return (Customer) repository.findByLastName(lastName);
    }

    public Customer save(Customer obj) {
        return repository.save(obj);
    }
}
