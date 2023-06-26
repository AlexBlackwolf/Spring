package com.example.demo.controller;

import com.example.demo.Meal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MealNameController {

    private List<Meal> meals;

    public MealNameController() {
        meals = new ArrayList<>();
        meals.add(new Meal("Pancakes", 9.99, "4/5"));
        meals.add(new Meal("Sandwich", 6.99, "3.5/5"));
        meals.add(new Meal("Pizza", 12.99, "5/5"));
    }

    @GetMapping("/meal/{name}")
    public Meal getMealByName(@PathVariable String name) {
        for (Meal meal : meals) {
            if (meal.getName().equalsIgnoreCase(name)) {
                return meal;
            }
        }
        return null;
    }
}
