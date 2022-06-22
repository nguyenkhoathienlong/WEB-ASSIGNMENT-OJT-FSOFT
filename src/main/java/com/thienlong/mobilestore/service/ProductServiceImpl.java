package com.thienlong.mobilestore.service;

import com.thienlong.mobilestore.entity.Product;
import com.thienlong.mobilestore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService{

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void delete(Long productID) {
        productRepository.deleteById(productID);
    }

    @Override
    public Optional<Product> findByID(Long productID) {
        return productRepository.findById(productID);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
