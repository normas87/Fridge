package com.normas.Fridge.component;


import com.normas.Fridge.Errors.ErrorHandler;
import com.normas.Fridge.foodProducts.FoodProductRepository;
import com.normas.Fridge.recipe.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MealService {

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    FoodProductRepository foodProductRepository;

    @Autowired
    MealRepository mealRepository;




        public List<Meal> getAllMeals() {
            List<Meal> meals = new ArrayList<>();
            mealRepository.findAll().forEach(meal -> meals.add(meal));
            return meals;
        }


        public Meal getMealById(long id) {
            Meal meal = mealRepository.findById(id).orElse(null);
            if (meal == null) {
                throw new ErrorHandler("Nie znaleziono składnika o id: " + id);
            } else {
                return mealRepository.findById(id).get();
            }
        }

        public void delete(long id) {
            mealRepository.deleteById(id);
        }


        public void updateMeal(long id, Meal updatedMeal) {
            mealRepository.findById(id).ifPresent(component -> {
                updatedMeal.setId(id);
                mealRepository.save(updatedMeal);
            });
        }

        public boolean save(Meal meal) {
            Meal meal1 = mealRepository.findByNameContainingIgnoreCase(meal.getName());
            if (meal == null) {
                mealRepository.save(meal);
            } else {
                throw new ErrorHandler("Podana nazwa posiłku już istnieje");
            }
            return true;
        }
}