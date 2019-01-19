package com.normas.Fridge.recipe;

import javax.persistence.*;
import java.util.List;

//@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private List products;
    private String timeToPreparation;
    private int people;
    private String description;
    private List nutritionalValues;


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

    public List getProducts() {
        return products;
    }

    public void setProducts(List products) {
        this.products = products;
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

    public List getNutritionalValues() {
        return nutritionalValues;
    }

    public void setNutritionalValues(List nutritionalValues) {
        this.nutritionalValues = nutritionalValues;
    }
}
