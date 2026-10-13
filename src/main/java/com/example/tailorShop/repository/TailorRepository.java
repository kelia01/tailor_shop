package com.example.tailorShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tailorShop.domain.Tailor;

import java.util.UUID;

public interface TailorRepository extends JpaRepository<Tailor, UUID> {}