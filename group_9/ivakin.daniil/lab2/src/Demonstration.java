import catBreed.CatBreed;
import catBreed.DomesticCatBreed;
import catBreed.Sphinx;
import catBreed.Mongrel;
import catBreed.Tiger;

import java.util.ArrayList;
import java.util.List;

public class Demonstration {

    public static List<CatBreed> chooseDomesticCats(List<CatBreed> cats) {
        return cats
                .stream()
                .filter(cat -> cat instanceof DomesticCatBreed)
                .toList();
    }

    public static List<Mongrel> chooseMongrels(List<CatBreed> cats) {
        return cats
                .stream()
                .filter(cat -> cat instanceof Mongrel)
                .map(cat -> (Mongrel) cat)
                .toList();
    }

    public static void feedCats(List<CatBreed> cats) {
        cats.forEach(CatBreed::eat);
    }

    public static void petMongrelCats(List<Mongrel> cats) {
        cats.forEach(CatBreed::tryPet);
    }

    public static CatBreed findCat(List<CatBreed> cats, CatBreed toFind) {
        return cats
                .stream()
                .filter(cat -> cat.equals(toFind))
                .findAny()
                .orElse(null);
    }

    public static void main(String[] args) {
        List<CatBreed> cats = new ArrayList<>();
        cats.add(new Mongrel("Orange", 4, "Rocket"));
        //cats.add(new Sphinx(1, "Boldy"));
        cats.add(new Tiger("White-Orange", 7, 11));
        cats.add(new Mongrel("Gray", 3, "Skinny"));
        cats.add(new Mongrel("White", 5, "Grumpy"));
        cats.add(new Mongrel("Gray", 4, "Bard"));
        cats.add(new Tiger("White", 5, 3));
        cats.add(new Tiger("Orange-White", 6, 15));
        cats.add(new Sphinx(7, "Tiny"));

        List<CatBreed> domesticCats = chooseDomesticCats(cats);
        feedCats(domesticCats);
        System.out.println();

        List<Mongrel> mongrels = chooseMongrels(domesticCats);
        petMongrelCats(mongrels);
        System.out.println();

        CatBreed searchedCat = findCat(cats, new Sphinx(1, "Boldy"));
        if (searchedCat != null) {
            System.out.println("We found your Sphinx cat named Boldy");
        } else {
            System.out.println(("Sorry, we couldn't find your Boldy Sphinx"));
        }
    }
}