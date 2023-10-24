package ru.alexanderhudyakov.lab3.restaurant;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Dish {
    private String name;
    private List<String> ingredients;
    private int price;
    public Dish(String name, Collection<String> ingredients, int price) {
        this.name = name;
        this.ingredients = new ArrayList<>(ingredients);
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    public List<String> getIngredients(){
        return  ingredients;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }
}
