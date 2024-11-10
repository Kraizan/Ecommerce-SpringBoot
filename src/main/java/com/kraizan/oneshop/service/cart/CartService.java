package com.kraizan.oneshop.service.cart;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.kraizan.oneshop.exceptions.ResourceNotFoundExpception;
import com.kraizan.oneshop.model.Cart;
import com.kraizan.oneshop.repository.CartItemRepository;
import com.kraizan.oneshop.repository.CartRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartService implements ICartService {
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;

    @Override
    public Cart getCart(Long id) {
        Cart cart = cartRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExpception("Cart not found"));
        return cart;
    }

    @Override
    public void clearCart(Long id) {
        Cart cart = getCart(id);
        cartItemRepository.deleteAllByCartId(id);
        cart.getCartItems().clear();
        cartRepository.deleteById(id);
    }

    @Override
    public BigDecimal getTotalPrice(Long id) {
        Cart cart = getCart(id);
        return cart.getTotalAmount();
    }

}
