package com.normas.Fridge.recipe;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RecipeSerializer extends StdSerializer<List<Recipe>> {

    public RecipeSerializer(){
        this(null);
    }

    private RecipeSerializer(Class<List<Recipe>> t) {
        super(t);
    }

    @Override
    public void serialize(List<Recipe> value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        List<String> ids = new ArrayList<>();
        for (Recipe item : value) {
            ids.add(item.getName());
        }
        gen.writeObject(ids);
    }
}