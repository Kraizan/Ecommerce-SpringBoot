package com.kraizan.oneshop.service.cart;

import java.math.BigDecimal;

import com.kraizan.oneshop.model.Cart;
import com.kraizan.oneshop.model.User;

public interface ICartService {
    Cart initializeNewCart(User user);
    Cart getCart(Long id);
    void clearCart(Long id);
    BigDecimal getTotalPrice(Long id);
    Cart getCartByUserId(Long userId);
}
