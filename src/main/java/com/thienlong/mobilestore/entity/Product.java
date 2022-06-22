package com.thienlong.mobilestore.entity;

import javax.persistence.*;

@Entity
@Table(name = "Products")
public class Product {
    @Id
    @Column(name = "product_id", length = 50,nullable = false)
    private Long productID; // ID // product_id
    @Column(name = "product_name", length = 50, nullable = false)
    private String productName;
    @Column(name = "unit_in_stock", nullable = false)
    private int unitInStock;
    @Column(name = "price", nullable = false)
    private float price;
    @Column(name = "description", length = 500, nullable = false)
    private String description;
    @Column(name = "product_images", length = 500, nullable = false)
    private String productImages;
    @Column(name = "manufacturer", length = 50, nullable = false)
    private String manufacturer;
    @Column(name = "category", length = 50, nullable = false)
    private String category;
    @Column(name = "condition_id", length = 50, nullable = false)
    private String condition_id;

    public Product() {
    }

    public Product(Long productID, String productName, int unitInStock, float price, String description, String productImages, String manufacturer, String category, String condition_id) {
        this.productID = productID;
        this.productName = productName;
        this.unitInStock = unitInStock;
        this.price = price;
        this.description = description;
        this.productImages = productImages;
        this.manufacturer = manufacturer;
        this.category = category;
        this.condition_id = condition_id;
    }

    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getUnitInStock() {
        return unitInStock;
    }

    public void setUnitInStock(int unitInStock) {
        this.unitInStock = unitInStock;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductImages() {
        return productImages;
    }

    public void setProductImages(String productImages) {
        this.productImages = productImages;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCondition_id() {
        return condition_id;
    }

    public void setCondition_id(String condition_id) {
        this.condition_id = condition_id;
    }
}
