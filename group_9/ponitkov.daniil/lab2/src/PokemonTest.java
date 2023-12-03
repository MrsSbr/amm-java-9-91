import pokemon.ElectricPokemon;
import pokemon.Pokemon;
import pokemon.WaterPokemon;

// Основной класс для демонстрации иерархии
public class PokemonTest {
    public static void main(String[] args) {
// Создаем экземпляры покемонов
        Pokemon pikachu = new ElectricPokemon("Pikachu", 30, "Electric");
        Pokemon squirtle = new WaterPokemon("Squirtle", 25, "Water");

// Вызываем методы для демонстрации
        pikachu.speak();
        squirtle.speak();

// Проверка на равенство и вывод информации о покемонах
        if (pikachu.equals(squirtle)) {
            System.out.println("Pikachu and Squirtle are the same Pokemon.");
        } else {
            System.out.println("Pikachu and Squirtle are different Pokemon.");
        }
        if (pikachu instanceof WaterPokemon) {
            System.out.println("Pikachu is Waterpokemon");
        }
        System.out.println("Pikachu: " + pikachu.toString());
        System.out.println("Squirtle: " + squirtle.toString());
    }
}