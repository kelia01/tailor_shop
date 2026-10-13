package com.example.tailorShop.controller;

import com.example.tailorShop.domain.Customer;
import com.example.tailorShop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping()
    public ResponseEntity<Customer> saveCustomer(
            @RequestBody Customer customer) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(customerService.saveCustomer(customer));
    }

    @GetMapping()
    public List<Customer> findAllCustomers() {
        return customerService.findAllCustomers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findCustomerById(
            @PathVariable UUID id) {

        return customerService.findCustomerById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(
            @PathVariable UUID id,
            @RequestBody Customer customer) {

        Customer updated = customerService.updateCustomer(id, customer);

        if (updated == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(
            @PathVariable UUID id) {

        if (!customerService.deleteCustomer(id)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}