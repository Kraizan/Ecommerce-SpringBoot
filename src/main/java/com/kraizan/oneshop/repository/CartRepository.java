package com.kraizan.oneshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kraizan.oneshop.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findByUserId(Long userId);
}
