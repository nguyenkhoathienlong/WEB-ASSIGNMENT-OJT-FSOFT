package com.thienlong.mobilestore.service;

import com.thienlong.mobilestore.entity.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {

    Product create(Product product);

    void save(Product product);

    void delete(Long productID);

    Optional<Product> findByID(Long productID);

    List<Product> findAll();


}
