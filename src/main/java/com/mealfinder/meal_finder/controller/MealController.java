package com.mealfinder.meal_finder.controller;

import com.mealfinder.meal_finder.entity.Meal;
import com.mealfinder.meal_finder.service.MealService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/meals")
public class MealController {

    private final MealService mealService;

    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @GetMapping
    public List<Meal> getAllMeals() {
        return mealService.getAllMeals();
    }

    @PostMapping
    public Meal addMeal(@RequestBody Meal meal) {
        return mealService.addMeal(meal);
    }

    @DeleteMapping("/{id}")
    public void deleteMeal(@PathVariable Long id) {
        mealService.deleteMeal(id);
    }
    @GetMapping("/under/{price}")
public List<Meal> getMealsUnderPrice(@PathVariable double price) {
    return mealService.getMealsUnderPrice(price);
}
@GetMapping("/category/{category}")
public List<Meal> getMealsByCategory(@PathVariable String category) {
    return mealService.getMealsByCategory(category);
}
@GetMapping("/restaurant/{restaurant}")
public List<Meal> getMealsByRestaurant(@PathVariable String restaurant) {
    return mealService.getMealsByRestaurant(restaurant);
}
@GetMapping("/search/{name}")
public List<Meal> searchMealsByName(@PathVariable String name) {
    return mealService.searchMealsByName(name);
}
@GetMapping("/vendor-type/{vendorType}")
public List<Meal> getMealsByVendorType(@PathVariable String vendorType) {
    return mealService.getMealsByVendorType(vendorType);
}
@GetMapping("/category/{category}/under/{price}")
public List<Meal> getMealsByCategoryAndPrice(
        @PathVariable String category,
        @PathVariable double price) {

    return mealService.getMealsByCategoryAndPrice(category, price);
}
@GetMapping("/sort/price")
public List<Meal> getMealsSortedByPrice() {
    return mealService.getMealsSortedByPrice();
}
}
