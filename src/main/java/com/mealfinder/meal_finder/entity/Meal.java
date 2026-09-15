package com.mealfinder.meal_finder.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String category;
    private double price;
    private String restaurant;
    private String vendorType;

    public Meal() {
    }

    public Meal(String name, String category, double price, String restaurant, String vendorType) {
    this.name = name;
    this.category = category;
    this.price = price;
    this.restaurant = restaurant;
    this.vendorType = vendorType;
}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }
    public String getVendorType() {
    return vendorType;
}

public void setVendorType(String vendorType) {
    this.vendorType = vendorType;
}
}