package moonshine;

import java.time.LocalDate;
import java.util.List;

public class Moonshine {
    private LocalDate date;
    private String name;
    private List<Ingredient> ingredients;
    private double volume;
    private double brewTimeDays;

    public Moonshine(LocalDate date, String name,
                     List<Ingredient> ingredients,
                     double volume, double brewTimeDays) {
        this.date = date;
        this.name = name;
        this.ingredients = ingredients;
        this.volume = volume;
        this.brewTimeDays = brewTimeDays;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getBrewTimeDays() {
        return brewTimeDays;
    }

    public void setBrewTimeDays(double brewTimeDays) {
        this.brewTimeDays = brewTimeDays;
    }
}
