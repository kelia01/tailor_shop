package com.example.tailorShop.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tailorShop.domain.Tailor;
import com.example.tailorShop.repository.TailorRepository;

import java.util.*;

@Service
public class TailorService {
    @Autowired
    private TailorRepository repository;

    public Tailor save(Tailor tailor) {
        return repository.save(tailor);
    }

    public List<Tailor> findAll() {
        return repository.findAll();
    }

    public Optional<Tailor> findById(UUID id) {
        return repository.findById(id);
    }

    public Tailor update(UUID id, Tailor details) {
        return repository.findById(id).map(t -> {
            t.setFirstName(details.getFirstName());
            t.setLastName(details.getLastName());
            t.setPhone(details.getPhone());
            t.setSpecialty(details.getSpecialty());
            return repository.save(t);
        }).orElse(null);
    }

    public boolean delete(UUID id) {
        if (!repository.existsById(id)) return false;
        repository.deleteById(id);
        return true;
    }
}