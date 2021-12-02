package br.sicredi.springjpa.service;

import br.sicredi.springjpa.model.Customer;
import br.sicredi.springjpa.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository repository;

    public List<Customer> findAll(){
        return (List<Customer>) repository.findAll();
    }

    public Optional findById(Long id) {
        return repository.findById(id);
    }

    public Customer findByLastName(String lastName) {
        return repository.findByLastName(lastName);
    }

    public void save(Customer customer) {
        repository.save(customer);
    }
}
