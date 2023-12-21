package org.sql.queries.cat;

public enum CatBreeds {
   MAINE_COON("Мейн-кун"),
   PERSIAN("Персидская"),
   BRITISH("Британская"),
   SCOTTISH("Шотландская"),
   BENGALI("Бенгальская"),
   SIAMESE("Сиамская"),
   NOT_BREED("Не породистая");
    private final String name;
    CatBreeds(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
