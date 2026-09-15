package com.mealfinder.meal_finder.service;

import com.mealfinder.meal_finder.entity.Meal;
import com.mealfinder.meal_finder.repository.MealRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {

    private final MealRepository mealRepository;

    public MealService(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    public List<Meal> getAllMeals() {
        return mealRepository.findAll();
    }
    public List<Meal> getMealsUnderPrice(double price) {
    return mealRepository.findByPriceLessThanEqual(price);
    }
    public List<Meal> getMealsByCategory(String category) {
    return mealRepository.findByCategory(category);
    }
    public List<Meal> getMealsByRestaurant(String restaurant) {
    return mealRepository.findByRestaurant(restaurant);
    }
    public List<Meal> searchMealsByName(String name) {
    return mealRepository.findByNameContainingIgnoreCase(name);
    }
    public List<Meal> getMealsByVendorType(String vendorType) {
    return mealRepository.findByVendorType(vendorType);
    }
    public List<Meal> getMealsByCategoryAndPrice(String category, double price) {
    return mealRepository.findByCategoryAndPriceLessThanEqual(category, price);
    }
    public List<Meal> getMealsSortedByPrice() {
    return mealRepository.findAllByOrderByPriceAsc();
    }
    public Meal addMeal(Meal meal) {
        return mealRepository.save(meal);
    }
    public void deleteMeal(Long id) {
        mealRepository.deleteById(id);
    }
}