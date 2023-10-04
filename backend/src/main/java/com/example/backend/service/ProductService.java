package com.example.backend.service;

import com.example.backend.model.Product;
import com.example.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public List<Product> loadAllProducts() {
        return productRepository.getAllProducts();
    }

    public Flux<Product> loadAllProductsStream() {
        return productRepository.getAllProductsStream();
    }

}
