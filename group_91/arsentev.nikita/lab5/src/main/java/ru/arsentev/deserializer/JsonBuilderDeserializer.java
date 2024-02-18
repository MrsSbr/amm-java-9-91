package ru.arsentev.deserializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import ru.arsentev.cat.typeadapter.CatTypeAdapter;
import ru.arsentev.entities.Cat;

public class JsonBuilderDeserializer {
    private static final Gson gson;

    static {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Cat.class, new CatTypeAdapter());
        gson = gsonBuilder.create();
    }

    public static Cat deserialize(String jsonString) throws JsonSyntaxException {
        return gson.fromJson(jsonString, Cat.class);
    }
}
