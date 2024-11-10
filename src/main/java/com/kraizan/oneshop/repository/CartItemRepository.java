package com.kraizan.oneshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kraizan.oneshop.model.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    void deleteAllByCartId(Long id);

}
