package com.normas.Fridge.foodProducts;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class FoodProductRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private FoodProductRepository foodProductRepository;

    @Test
    public void when_no_data_return_empty_list(){
        //given
        //when
        List<FoodProduct> foodProducts = foodProductRepository.findAll();
        //then
        Assert.assertEquals(0, foodProducts.size());
    }
}