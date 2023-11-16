import Pokemon.Pokemon;
import Pokemon.ElectricPokemon;
import Pokemon.WaterPokemon;

// Основной класс для демонстрации иерархии
public class PokemonHierarchyDemo {
    public static void main(String[] args) {
        Pokemon[] pokemons = new Pokemon[] {
                new ElectricPokemon("Pikachu", 30, "Electric"),
                new WaterPokemon("Squirtle", 25, "Water"),
        };

        for (Pokemon pokemon : pokemons) {
            if (pokemon instanceof ElectricPokemon electricPokemon) {
                System.out.println("Electric pokemon, type: " + electricPokemon.getType());
                System.out.println(electricPokemon.toString());
            }
            else if (pokemon instanceof WaterPokemon waterPokemon) {
                System.out.println("Water pokemon, habitat: " + waterPokemon.getHabitat());
                System.out.println(waterPokemon.toString());
            }
        }
    }
}