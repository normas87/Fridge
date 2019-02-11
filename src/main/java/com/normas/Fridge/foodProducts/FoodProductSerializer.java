package com.normas.Fridge.foodProducts;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.normas.Fridge.recipe.Recipe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FoodProductSerializer extends StdSerializer<List<FoodProduct>> {

    public FoodProductSerializer() {
        this(null);
    }

    private FoodProductSerializer(Class<List<FoodProduct>> t) {
        super(t);
    }

    @Override
    public void serialize(List<FoodProduct> value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        List<String> ids = new ArrayList<>();
        for (FoodProduct item : value) {
            ids.add(item.getName());
        }
        gen.writeObject(ids);
    }
}