package com.normas.Fridge.component;

import com.normas.Fridge.recipe.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository extends JpaRepository<Meal, Long> {
    Meal findByNameContainingIgnoreCase(String name);
}
