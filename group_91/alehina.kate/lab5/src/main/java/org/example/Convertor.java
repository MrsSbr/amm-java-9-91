package org.example;

import org.example.cat.Breed;
import org.example.cat.Cat;
import org.example.cat.Gender;

public class Convertor {
    public static void main(String[] args) {
        // Сериализация объекта в JSON
        Cat cat = new Cat("Мурка", 3, Gender.FEMALE, Breed.THAI, true);
        String jsonResult = JsonUtils.serialize(cat);
        System.out.println(jsonResult);

        // Десериализация JSON в объект
        String json = "{\"name\":\"Мурка\",\"age\":3,\"gender\":FEMALE,\"breed\":THAI,\"defertilized\":true}";
        Cat deserializedCat = JsonUtils.deserialize(json, Cat.class);
        if(deserializedCat != null) {
            System.out.println(deserializedCat.getName());
            System.out.println(deserializedCat.getAge());
            System.out.println(deserializedCat.getGender());
            System.out.println(deserializedCat.getBreed());
            System.out.println(deserializedCat.isDefertilized());
        } else {
            System.out.println ("Возникла проблема! Не удалось провести десериализацию");
        }
    }
}