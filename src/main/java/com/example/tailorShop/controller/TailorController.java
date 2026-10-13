package com.example.tailorShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.tailorShop.domain.Tailor;
import com.example.tailorShop.service.TailorService;

import java.util.*;

@RestController
@RequestMapping("/api/tailors")
public class TailorController {
    @Autowired
    private TailorService service;

    @PostMapping
    public ResponseEntity<Tailor> save(@RequestBody Tailor t) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(t));
    }

    @GetMapping
    public List<Tailor> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tailor> findById(@PathVariable UUID id) {
        return service.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tailor> update(
            @PathVariable UUID id, @RequestBody Tailor t) {
        Tailor result = service.update(id, t);
        return result == null ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        return service.delete(id) ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
