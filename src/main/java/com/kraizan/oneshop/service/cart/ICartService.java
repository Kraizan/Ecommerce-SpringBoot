package com.kraizan.oneshop.service.cart;

import java.math.BigDecimal;

import com.kraizan.oneshop.model.Cart;

public interface ICartService {
    Cart getCart(Long id);
    void clearCart(Long id);
    BigDecimal getTotalPrice(Long id);
}
