package com.wolverineteam.onlinemarket.models;

import javax.persistence.*;

@Entity
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductID")
    private int id;


    @Column(name = "BrandID")
    private String brand;

    @Column(name = "Model")
    private String model;


    @Column(name = "CategoryID")
    private String category;

    @Column(name = "Description")
    private String description;

    @Column(name = "Quantity")
    private int quantity;

    public Product(){

    }

    public Product(String brand, String model, String category, String description, int quantity) {
        this.brand = brand;
        this.model = model;
        this.category = category;
        this.description = description;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
