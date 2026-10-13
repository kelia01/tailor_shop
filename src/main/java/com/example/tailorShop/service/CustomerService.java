package com.example.tailorShop.service;

import com.example.tailorShop.domain.Customer;
import com.example.tailorShop.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> findCustomerById(UUID id) {
        return customerRepository.findById(id);
    }

    public Customer updateCustomer(UUID id, Customer details) {
        return customerRepository.findById(id)
                .map(customer -> {
                    customer.setFirstName(details.getFirstName());
                    customer.setLastName(details.getLastName());
                    customer.setPhone(details.getPhone());
                    customer.setAddress(details.getAddress());

                    return customerRepository.save(customer);
                })
                .orElse(null);
    }

    public boolean deleteCustomer(UUID id) {
        if (!customerRepository.existsById(id)) {
            return false;
        }

        customerRepository.deleteById(id);
        return true;
    }
}