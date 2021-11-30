package br.sicredi.springjpa.controller;

import br.sicredi.springjpa.model.Customer;
import br.sicredi.springjpa.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {
    @Autowired
    private CustomerService service;

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

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Customer obj) {
        obj = service.save(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
