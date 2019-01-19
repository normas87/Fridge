package com.normas.Fridge.foodProducts;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodProductRepository extends JpaRepository <FoodProduct, Long>{
    List<FoodProduct> findAll();
}
