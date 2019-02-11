package com.normas.Fridge.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MealController {

    @Autowired
    private MealService mealService;

    @GetMapping("/meals")
    private List<Meal> getAll() {
        return mealService.getAllMeals();
    }

    @GetMapping("meals/{id}")
    private Meal getMeal(@PathVariable("id") long id) {
        return mealService.getMealById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/meals/{id}")
    private Meal updateMeal(@RequestBody Meal meal, @PathVariable("id") long id) {
        mealService.updateMeal(id, meal);
        return meal;
    }

    @PostMapping("/components")
    private Meal addMeal(@RequestBody Meal meal) {
        mealService.save(meal);
        return meal;
    }

    @DeleteMapping("components/{id}")
    private void deleteMeal(@PathVariable("id") long id) {
        mealService.delete(id);
    }
}
