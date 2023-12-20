package moonshine;

public enum Ingredient {
    ICE("Лёд"),
    LEMON("Лимон"),
    VODKA("Водка"),
    LIME("Лайм"),
    SYRUP("Сироп"),
    JUICE("Сок");

    private final String ingredient;

    Ingredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getIngredient() {
        return ingredient;
    }
}
