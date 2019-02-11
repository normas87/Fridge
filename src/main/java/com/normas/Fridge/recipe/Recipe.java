package com.normas.Fridge.recipe;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.normas.Fridge.component.Meal;
import com.normas.Fridge.foodProducts.FoodProduct;
import com.normas.Fridge.foodProducts.FoodProductSerializer;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    private String name;
    private String timeToPreparation;
    private int people;
    private String description;

    @JsonSerialize(using = FoodProductSerializer.class)
    @ManyToMany
    private List<FoodProduct> foodProducts;


    @ManyToMany
    private List<Meal> mels = new ArrayList<>();


    public void setProducts(List<FoodProduct> products) {
        this.foodProducts = products;
    }

    public List<FoodProduct> getFoodProducts() {
        return foodProducts;
    }

    public void setFoodProducts(List<FoodProduct> foodProducts) {
        this.foodProducts = foodProducts;
    }

    public void addFoodProduct(FoodProduct foodProduct) {
        this.foodProducts.add(foodProduct);
    }

    public Recipe() {
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

    public String getTimeToPreparation() {
        return timeToPreparation;
    }

    public void setTimeToPreparation(String timeToPreparation) {
        this.timeToPreparation = timeToPreparation;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
