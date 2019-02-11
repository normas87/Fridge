package com.normas.Fridge.recipe;

import com.normas.Fridge.Errors.ErrorHandler;
import com.normas.Fridge.foodProducts.FoodProduct;
import com.normas.Fridge.foodProducts.FoodProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService {

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    FoodProductRepository foodProductRepository;


    public List<Recipe> getAllRecipes() {
        List<Recipe> recipes = new ArrayList<>();
        recipeRepository.findAll().forEach(recipe -> recipes.add(recipe));
        return recipes;
    }

    public Recipe getRecipeById(long id) {
        Recipe recipe = recipeRepository.findById(id).orElse(null);
        if (recipe == null) {
            throw new ErrorHandler("Nie znaleziono przepisu o id: " + id);
        } else {
        } return recipeRepository.findById(id).get();
    }

    public void delete(long id) {
        recipeRepository.deleteById(id);
    }

    public void updateRecipe(long id, Recipe updatedRecipe) {
        recipeRepository.findById(id).ifPresent(recipe -> {
            updatedRecipe.setId(id);
            recipeRepository.save(updatedRecipe);
        });
    }


    public boolean save(Recipe recipe) {
        Recipe recipes = recipeRepository.findByNameContainingIgnoreCase(recipe.getName());
        if (recipes == null) {
            List<FoodProduct>fp = new ArrayList<>();
            for (FoodProduct foodProduct: recipe.getFoodProducts()) {
                FoodProduct dbFoodProduct = foodProductRepository.findById(foodProduct.getId()).get();
                fp.add(dbFoodProduct);
                dbFoodProduct.addFoodProduct(recipe);
            }
            recipe.setFoodProducts(fp);
            recipeRepository.save(recipe);
        } else {
            throw new ErrorHandler("Podana nazwa przepisu już istnieje");
        }
        return true;
    }
}