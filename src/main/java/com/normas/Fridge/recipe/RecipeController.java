package com.normas.Fridge.recipe;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping("/recipes")
    private List<Recipe> getAll() {
        return recipeService.getAllRecipes();
    }

    @GetMapping("recipes/{id}")
    private Recipe getRecipe(@PathVariable("id") long id) {
        return recipeService.getRecipeById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/recipe/{id}")
    private Recipe updateRecipe(@RequestBody Recipe recipe, @PathVariable("id") long id) {
        recipeService.updateRecipe(id, recipe);
        return recipe;
    }


    @PostMapping("/recipes")
    private Recipe addRecipe (@RequestBody Recipe recipe){
        recipeService.save(recipe);
        return recipe;
    }

    @DeleteMapping ("/recipes/{id}")
    private void deleteRecipe(@PathVariable("id") long id){
        recipeService.delete(id);
    }
}

