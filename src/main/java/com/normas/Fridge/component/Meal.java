package com.normas.Fridge.component;

import com.normas.Fridge.foodProducts.FoodProduct;
import com.normas.Fridge.recipe.Recipe;

import javax.persistence.*;
import java.util.List;

@Entity
public class Meal {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        long id;
        private String name;

        private int amount;


    @ManyToMany
    private List<FoodProduct> foodProducts;

    @ManyToMany
    private List<Recipe> recipes;

    public List<FoodProduct> getFoodProducts() {
        return foodProducts;
    }

    public void setFoodProducts(List<FoodProduct> foodProducts) {
        this.foodProducts = foodProducts;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }



    public Meal() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
