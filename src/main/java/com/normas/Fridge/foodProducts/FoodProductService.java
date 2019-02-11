package com.normas.Fridge.foodProducts;

import com.normas.Fridge.Errors.ErrorHandler;
import com.normas.Fridge.recipe.Recipe;
import com.normas.Fridge.recipe.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodProductService {

    private FoodProductRepository foodProductRepository;

    private RecipeRepository recipeRepository;

    @Autowired
    public FoodProductService(FoodProductRepository foodProductRepository, RecipeRepository recipeRepository) {
        this.foodProductRepository = foodProductRepository;
        this.recipeRepository = recipeRepository;
    }

    public List<FoodProduct> getAllFoodProducts() {
        List<FoodProduct> foodProducts = new ArrayList<>();
        foodProductRepository.findAll().forEach(foodProduct -> foodProducts.add(foodProduct));
        return foodProducts;
    }

    public FoodProduct getFoodProductById(long id) {
        FoodProduct foodProduct = foodProductRepository.findById(id).orElse(null);
        if (foodProduct == null) {
            throw new ErrorHandler("Nie znaleziono produktu o id: " + id);
        } else {
            return foodProductRepository.findById(id).get();
        }
    }

    public void delete(long id) {
        foodProductRepository.deleteById(id);
    }


    public void updateFoodProduct(long id, FoodProduct updatedFoodProduct) {
        foodProductRepository.findById(id).ifPresent(foodProduct -> {
            updatedFoodProduct.setId(id);
            foodProductRepository.save(updatedFoodProduct);
        });
    }

    public boolean save(FoodProduct foodProduct) {
        FoodProduct foodProducts = foodProductRepository.findByNameContainingIgnoreCase(foodProduct.getName());
        if (foodProducts == null) {
            foodProductRepository.save(foodProduct);
        } else {
            throw new ErrorHandler("Podana nazwa produktu już istnieje");
        }
        return true;
    }
}
