package com.kraizan.oneshop.exceptions;

public class ProductNotFoundExpception extends RuntimeException {
    public ProductNotFoundExpception(String message) {
        super(message);
    }
}
