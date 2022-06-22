package com.thienlong.mobilestore.repository;

import java.util.List;

import com.thienlong.mobilestore.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, CrudRepository<Product, Long> {
    public List<Product> findByProductID(Product product);
}
