package com.kraizan.oneshop.request;

import java.math.BigDecimal;

import com.kraizan.oneshop.model.Category;

import lombok.Data;

@Data
public class ProductUpdateRequest {
    private String name;
    private String brand;
    private String description;
    private BigDecimal price;
    private int inventory;
    private Category category;
}
