package com.mealfinder.meal_finder.repository;

import com.mealfinder.meal_finder.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MealRepository extends JpaRepository<Meal, Long> {

    List<Meal> findByPriceLessThanEqual(double price);
    List<Meal> findByCategory(String category);
    List<Meal> findByRestaurant(String restaurant);
    List<Meal> findByNameContainingIgnoreCase(String name);
    List<Meal> findByVendorType(String vendorType);
    List<Meal> findByCategoryAndPriceLessThanEqual(String category, double price);
    List<Meal> findAllByOrderByPriceAsc();
}