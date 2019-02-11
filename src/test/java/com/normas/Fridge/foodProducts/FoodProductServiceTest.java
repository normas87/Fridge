package com.normas.Fridge.foodProducts;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class FoodProductServiceTest {

    @TestConfiguration
    static class FoodProductImplTestContextConfiguration {
        @Bean
        public FoodProduct foodProduct(){
            return new FoodProduct();
        }
    }

    @Autowired
    private FoodProductService foodProductService;

    @Autowired
    private FoodProductRepository foodProductRepository;

    @Test
    public void productAddTest(){
        //given
        FoodProduct foodProduct = new FoodProduct();

        //whem
        foodProductService.save(foodProduct);
        foodProduct.setName("Pomidor");
      //  foodProductService.gettAllFoodProducts();

        //then
        Assert.assertTrue(foodProduct.getName(), true);
    }

}