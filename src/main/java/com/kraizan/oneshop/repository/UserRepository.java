package com.kraizan.oneshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kraizan.oneshop.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
}
