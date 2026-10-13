package com.example.tailorShop.repository;

import com.example.tailorShop.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface CustomerRepository
        extends JpaRepository<Customer, UUID> {
}