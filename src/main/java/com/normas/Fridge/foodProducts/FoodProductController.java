package com.normas.Fridge.foodProducts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FoodProductController {

    @Autowired
   private FoodProductService foodProductService;

    @GetMapping("/products")
    private List<FoodProduct> getAll() {
        return foodProductService.getAllFoodProducts();
    }

    @GetMapping("products/{id}")
    private FoodProduct getProduct(@PathVariable("id") long id) {
        return foodProductService.getFoodProductById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/products/{id}")
    private FoodProduct updateProduct(@RequestBody FoodProduct foodProduct, @PathVariable("id") long id) {
        foodProductService.updateFoodProduct(id, foodProduct);
    return foodProduct;
    }

    @PostMapping("/products")
    private FoodProduct addProduct(@RequestBody FoodProduct foodProduct) {
        foodProductService.save(foodProduct);
        return foodProduct;
    }

    @DeleteMapping("products/{id}")
    private void deleteProduct(@PathVariable("id") long id){
        foodProductService.delete(id);
    }
}

