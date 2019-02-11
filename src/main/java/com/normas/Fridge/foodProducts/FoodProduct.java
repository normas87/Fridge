package com.normas.Fridge.foodProducts;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.normas.Fridge.component.Meal;
import com.normas.Fridge.recipe.Recipe;
import com.normas.Fridge.recipe.RecipeSerializer;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class FoodProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    private String name;
    private double price;
    private double kcal;
    private double carbs;
    private double fats;
    private double proteins;
    private boolean vege;


    @JsonIgnore
    @ManyToMany
    private List<Recipe> recipes = new ArrayList<>();

    @ManyToMany
    private List<Meal> mels = new ArrayList<>();

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public void addFoodProduct(Recipe recipe) {
        this.recipes.add(recipe);
    }


    public FoodProduct() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getKcal() {
        return kcal;
    }

    public void setKcal(double kcal) {
        this.kcal = kcal;
    }

    public double getCarbs() {
        return carbs;
    }

    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }

    public double getFats() {
        return fats;
    }

    public void setFats(double fats) {
        this.fats = fats;
    }

    public double getProteins() {
        return proteins;
    }

    public void setProteins(double proteins) {
        this.proteins = proteins;
    }

    public boolean isVege() {
        return vege;
    }

    public void setVege(boolean vege) {
        this.vege = vege;
    }
}
