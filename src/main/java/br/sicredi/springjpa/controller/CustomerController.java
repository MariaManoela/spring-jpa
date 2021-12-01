package br.sicredi.springjpa.controller;

import br.sicredi.springjpa.model.Customer;
import br.sicredi.springjpa.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {
    @Autowired
    private CustomerService service;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Customer customer) {
        service.save(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> findAll() {
        List<Customer> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public Optional<Customer> findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @GetMapping("/lastName")
    public List<Customer> findByLastName(@RequestParam String lastName) {
        return (List<Customer>) service.findByLastName(lastName);
    }
}
