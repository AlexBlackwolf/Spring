package com.example.demo.controller;

import com.example.demo.Meal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

public class MealRatingController {
    private List<Meal> meals;

    public MealRatingController() {
        meals = new ArrayList<>();
        meals.add(new Meal("Pancakes", 9.99, "4/5"));
        meals.add(new Meal("Sandwich", 6.99, "3.5/5"));
        meals.add(new Meal("Pizza", 12.99, "5/5"));
    }

    @GetMapping("/meal/rating/{rating}")
    public List<Meal> getMealsByRating(@PathVariable("rating") String rating) {
        List<Meal> matchingMeals = new ArrayList<>();
        for (Meal meal : meals) {
            if (meal.getRating().equals(rating)) {
                matchingMeals.add(meal);
            }
        }
        return matchingMeals;
    }
}

