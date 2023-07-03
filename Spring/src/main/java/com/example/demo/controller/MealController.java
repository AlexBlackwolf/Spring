package com.example.demo.controller;

import com.example.demo.Meal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class MealController {
     public List<Meal> meals = Arrays.asList(
            new Meal("Pancakes", 9.99, "4/5"),
            new Meal("Sandwich", 6.99, "3.5/5"),
            new Meal("Pizza", 12.99, "5/5")
    );

    @GetMapping("/meals")
    public ResponseEntity<List<Meal>> getMeals() {
        return ResponseEntity.ok(meals);
    }
}