package com.example.demo.controller;

import com.example.demo.Meal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

public class MealPriceController {

    private List<Meal> meals;

    public MealPriceController() {
        meals = new ArrayList<>();
        meals.add(new Meal("Pancakes", 9.99, "4/5"));
        meals.add(new Meal("Sandwich", 6.99, "3.5/5"));
        meals.add(new Meal("Pizza", 12.99, "5/5"));
    }
    @GetMapping("/meal/price")
    public List<Meal> getMealsByPriceRange(@RequestParam("min") double minPrice, @RequestParam("max") double maxPrice) {
        List<Meal> matchingMeals = new ArrayList<>();
        for (Meal meal : meals) {
            if (meal.getPrice() >= minPrice && meal.getPrice() <= maxPrice) {
                matchingMeals.add(meal);
            }
        }
        return matchingMeals;
    }
}
