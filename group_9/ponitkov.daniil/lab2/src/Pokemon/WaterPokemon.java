package Pokemon;

import java.util.Objects;

// Наследник класса AbstractPokemon, представляющий водного покемона
public class WaterPokemon extends AbstractPokemon {
    private String habitat;

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    // Конструктор с параметрами, использующий конструктор класса-предка
    public WaterPokemon(String name, int level, String habitat) {
        super(name, level);
        this.habitat = habitat;
    }

    // Реализация метода speak для водных покемонов
    @Override
    public void speak() {
        System.out.println("I am a Water Pokemon! Habitat: " + habitat);
    }

    @Override
    public String toString() {
        return "Покемон " + habitat;
    }

    // Переопределение метода equals для сравнения двух покемонов
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Если объекты ссылаются на одну и ту же память
        if (obj == null || getClass() != obj.getClass()) return false; // Если объекты разных классов
        WaterPokemon that = (WaterPokemon) obj;
        return super.equals(obj) && habitat.equals(that.habitat); // Сравнение полей
    }

    // Переопределение метода hashCode для вычисления хэш-кода покемона
    @Override
    public int hashCode() {
        int result = habitat.hashCode(); // Хэш-код для поля habitat
        return Objects.hash(super.hashCode(), result);
    }
}