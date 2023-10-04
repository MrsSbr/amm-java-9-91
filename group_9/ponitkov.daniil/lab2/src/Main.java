
// Основной класс для демонстрации иерархии
public class Main  {
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

        System.out.println("Pikachu: " + pikachu.toString());
        System.out.println("Squirtle: " + squirtle.toString());
    }
}