package com.smartbuy.model;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private double price;
    private  int stock;
    private String category;
    private  String imageUrl;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String descrription) {
        this.description = descrription;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

//    public Product(String category, String descrription, long id, String imageUrl, String name, double price, int stock) {
//        this.category = category;
//        this.descrription = descrription;
//        this.id = id;
//        this.imageUrl = imageUrl;
//        this.name = name;
//        this.price = price;
//        this.stock = stock;
//    }

    @Override
    public String toString() {
        return "Product{" +
                "category='" + category + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", descrription='" + description + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
