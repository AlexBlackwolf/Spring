package com.example.demo.controller;

import com.example.demo.Meal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class MealController3 {
    List<Meal> mealList = new ArrayList<>();

    @GetMapping("/get/meals")
    public ResponseEntity<List<Meal>> getMeals() {
        return ResponseEntity.ok(mealList);
    }

    @PostMapping("/meal")
    public ResponseEntity<String> addMeal(@RequestBody Meal newMeal) {
        mealList.add(newMeal);
        return ResponseEntity.ok("Meal added successfully");
    }

    @PutMapping("/meal/{name}")
    public ResponseEntity<String> updateMealByName(@PathVariable String name, @RequestBody Meal updatedMeal) {
        for (Meal meal : mealList) {
            if (meal.getName().equals(name)) {
                meal.setName(updatedMeal.getName());
                meal.setPrice(updatedMeal.getPrice());
                meal.setRating(updatedMeal.getRating());
                return ResponseEntity.ok("Meal updated successfully");
            }
        }
        return ResponseEntity.notFound().build(); // Return 404 if meal not found
    }

    @DeleteMapping("/meal/{name}")
    public ResponseEntity<String> deleteMealByName(@PathVariable String name) {
        Iterator<Meal> iterator = mealList.iterator();
        while (iterator.hasNext()) {
            Meal meal = iterator.next();
            if (meal.getName().equals(name)) {
                iterator.remove();
                return ResponseEntity.ok("Meal deleted successfully");
            }
        }
        return ResponseEntity.notFound().build(); // Return 404 if meal not found
    }

    @DeleteMapping("/meal/price/{price}")
    public ResponseEntity<String> deleteMealsAbovePrice(@PathVariable double price) {
        Iterator<Meal> iterator = mealList.iterator();
        while (iterator.hasNext()) {
            Meal meal = iterator.next();
            if (meal.getPrice() > price) {
                iterator.remove();
            }
        }
        return ResponseEntity.ok("Meals deleted successfully");
    }

    @PutMapping("/meal/{name}/price")
    public ResponseEntity<String> updateMealPriceByName(@PathVariable String name, @RequestBody double updatedPrice) {
        for (Meal meal : mealList) {
            if (meal.getName().equals(name)) {
                meal.setPrice(updatedPrice);
                return ResponseEntity.ok("Meal price updated successfully");
            }
        }
        return ResponseEntity.notFound().build();
    }
}
