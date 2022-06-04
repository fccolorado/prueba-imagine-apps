package com.prueba.pruebaimagineapps.service;

import com.prueba.pruebaimagineapps.model.Product;

import java.util.Optional;

public interface ProductService {
    public Product  save(Product product);
    public Optional<Product> get(Integer id);
    public void update(Product product);
    public void delete(Integer id);
}
