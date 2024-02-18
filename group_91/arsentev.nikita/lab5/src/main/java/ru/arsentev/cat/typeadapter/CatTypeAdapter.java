package ru.arsentev.cat.typeadapter;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import ru.arsentev.entities.Cat;
import ru.arsentev.entities.Color;
import ru.arsentev.entities.Gender;


public class CatTypeAdapter extends TypeAdapter<Cat> {

    @Override
    public void write(JsonWriter out, Cat value) {
    }


    @Override
    public Cat read(JsonReader jsonReader) {
        JsonObject jsonObject = JsonParser.parseReader(jsonReader).getAsJsonObject();

        Cat cat = new Cat();

        JsonElement nameElement = jsonObject.get("name");
        if (nameElement != null && !nameElement.isJsonNull()) {
            cat.setName(nameElement.getAsString());
        }

        JsonElement ageElement = jsonObject.get("age");
        if (ageElement != null && !ageElement.isJsonNull()) {
            cat.setAge(ageElement.getAsInt());
        }

        JsonElement weightElement = jsonObject.get("weight");
        if (weightElement != null && !weightElement.isJsonNull()) {
            cat.setWeight(weightElement.getAsDouble());
        }

        JsonElement colorElement = jsonObject.get("color");
        if (colorElement != null && !colorElement.isJsonNull()) {
            cat.setColor(Color.valueOf(colorElement.getAsString().toUpperCase()));
        }

        JsonElement genderElement = jsonObject.get("gender");
        if (genderElement != null && !genderElement.isJsonNull()) {
            cat.setGender(Gender.valueOf(genderElement.getAsString().toUpperCase()));
        }

        JsonElement isPleasedElement = jsonObject.get("isPleased");
        if (isPleasedElement != null && !isPleasedElement.isJsonNull()) {
            cat.setIsPleased(isPleasedElement.getAsBoolean());
        }

        return cat;
    }
}
