package com.kraizan.oneshop.service.product;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kraizan.oneshop.exceptions.ResourceNotFoundExpception;
import com.kraizan.oneshop.model.Category;
import com.kraizan.oneshop.model.Product;
import com.kraizan.oneshop.repository.CategoryRepository;
import com.kraizan.oneshop.repository.ProductRepository;
import com.kraizan.oneshop.request.AddProductRequest;
import com.kraizan.oneshop.request.ProductUpdateRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public Product addProduct(AddProductRequest request) {
        System.out.println(request);
        Category category = Optional.ofNullable(categoryRepository.findByName(request.getCategory().getName()))
                .orElseGet(()->{
                    System.out.println(request.getCategory());
                    Category newCategory = new Category(request.getCategory().getName());
                    System.out.println(newCategory);
                    return categoryRepository.save(newCategory);
                });
        request.setCategory(category);
        System.out.println(request);
        return productRepository.save(createProduct(request));
    }

    private Product createProduct(AddProductRequest request){
        return new Product(
                request.getName(),
                request.getBrand(),
                request.getDescription(),
                request.getInventory(),
                request.getCategory(),
                request.getPrice()
        );
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExpception("Product not found!"));
    }

    @Override
    public Product updateProduct(Long id, ProductUpdateRequest product) {
        return productRepository.findById(id)
                .map((existingProduct) -> updateExistingProduct(existingProduct, product))
                .map(productRepository :: save)
                .orElseThrow(() -> new ResourceNotFoundExpception("Product not found!"));
    }

    private Product updateExistingProduct(Product existingProduct, ProductUpdateRequest request){
        existingProduct.setName(request.getName());
        existingProduct.setBrand(request.getBrand());
        existingProduct.setDescription(request.getDescription());
        existingProduct.setInventory(request.getInventory());
        existingProduct.setPrice(request.getPrice());

        Category category = categoryRepository.findByName(request.getCategory().getName());
        existingProduct.setCategory(category);

        return existingProduct;
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.findById(id)
                .ifPresentOrElse(productRepository::delete,
                        () -> {throw new ResourceNotFoundExpception("Product not found!");});
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategoryName(category);
    }

    @Override
    public List<Product> getProductsByBrand(String brand) {
        return productRepository.findByBrand(brand);
    }

    @Override
    public List<Product> getProductsByCategoryAndBrand(String category, String brand) {
        return productRepository.findByCategoryNameAndBrand(category, brand);
    }

    @Override
    public List<Product> getProductsByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public List<Product> getProductsByBrandAndName(String brand, String name) {
        return productRepository.findByBrandAndName(brand, name);
    }

    @Override
    public Long countProductsByBrandAndName(String brand, String name) {
        return productRepository.countByBrandAndName(brand, name);
    }
}
