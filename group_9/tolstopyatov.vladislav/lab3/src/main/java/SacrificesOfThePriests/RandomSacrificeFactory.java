package SacrificesOfThePriests;

import java.util.List;
import java.util.Random;

public class RandomSacrificeFactory {
    private static final List<Sacrifice> SACRIFICES;

    static {
        SACRIFICES = List.of(
                new Sacrifice("человек", "мальчик"),
                new Sacrifice("человек", "девочка"),
                new Sacrifice("человек", "юноша"),
                new Sacrifice("человек", "девушка"),
                new Sacrifice("человек", "мужчина"),
                new Sacrifice("человек", "женщина"),
                new Sacrifice("человек", "пожилой мужчина"),
                new Sacrifice("человек", "пожилая женщина"),
                new Sacrifice("человек", "младенец мальчик"),
                new Sacrifice("человек", "младенец девочка"),
                new Sacrifice("животное", "кошка"),
                new Sacrifice("животное", "кот"),
                new Sacrifice("животное", "собака"),
                new Sacrifice("животное", "черепаха"),
                new Sacrifice("животное", "птица"),
                new Sacrifice("животное", "змея"),
                new Sacrifice("животное", "бык"),
                new Sacrifice("животное", "осёл"),
                new Sacrifice("животное", "олень"),
                new Sacrifice("животное", "свинья"),
                new Sacrifice("материальный объект", "палка"),
                new Sacrifice("материальный объект", "стол"),
                new Sacrifice("материальный объект", "кость"),
                new Sacrifice("материальный объект", "бусы"),
                new Sacrifice("материальный объект", "дубинка"),
                new Sacrifice("материальный объект", "корзинка"),
                new Sacrifice("материальный объект", "клык"),
                new Sacrifice("материальный объект", "копьё"),
                new Sacrifice("материальный объект", "камень"),
                new Sacrifice("материальный объект", "бревно")
        );
    }

    public Sacrifice getSacrifice() {
        Random rand = new Random();
        return SACRIFICES.get(rand.nextInt(SACRIFICES.size()));
    }
}
