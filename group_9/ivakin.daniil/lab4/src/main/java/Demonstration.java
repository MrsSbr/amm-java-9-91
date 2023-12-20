import moonshine.Ingredient;
import moonshine.Moonshine;
import moonshine.MoonshineInfo;
import moonshine.MoonshineReader;

import java.nio.file.Path;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Demonstration {
    private static final Path PATH = Path.of("group_9/ivakin.daniil/lab4/src/main/resources/moonshines.txt");
    private static final Logger logger = Logger.getLogger(Demonstration.class.getName());

    public static void main(String[] args) {

        logger.log(Level.INFO, "Начало демнострации");

        MoonshineReader moonshineReader = new MoonshineReader();
        MoonshineInfo moonshineInfo = new MoonshineInfo();

        try {
            List<Moonshine> moonshines = moonshineReader.readMoonshines(PATH);

            System.out.println("Среднее время настаиваивания ингредиентов в днях:");
            moonshineInfo.getAvgBrewTimeForIngredients(moonshines)
                    .forEach(((ingredient, brewTime) ->
                            System.out.println(ingredient.getIngredient() + " : " + brewTime)));

            System.out.println("\nМесяц, в котором использовалось больше всего ингредиентов:");
            moonshineInfo.getMonthWithMaxIngredients(moonshines)
                    .ifPresentOrElse(month -> System.out.println(month.name()),
                            () -> System.out.println("Переданный список настоек пуст"));

            System.out.println("\nСуммарный объём для каждой настойки:");
            moonshineInfo.getTotalValueForMoonshines(moonshines)
                    .forEach(((moonshine, volume) ->
                            System.out.println(moonshine + " : " + volume)));

            System.out.println();

        } catch (Exception ex) {
            logger.log(Level.SEVERE,"Перехвачено исключение: " + ex.getMessage());
        }
        logger.log(Level.FINE, "Конец демонстрации");
    }
}