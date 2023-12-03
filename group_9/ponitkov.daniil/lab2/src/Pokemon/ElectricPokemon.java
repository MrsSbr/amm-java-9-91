package Pokemon;

import java.util.Objects;

// Наследник класса AbstractPokemon, представляющий электрического покемона
public class ElectricPokemon extends AbstractPokemon {
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // Конструктор с параметрами, использующий конструктор класса-предка
    public ElectricPokemon(String name, int level, String type) {
        super(name, level);
        this.type = type;
    }

    // Реализация метода speak для электрических покемонов
    @Override
    public void speak() {
        System.out.println("I am an Electric Pokemon! Type: " + type);
    }

    @Override
    public String toString() {
        return "Покемон " + type;
    }

    // Переопределение метода equals для сравнения двух покемонов
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Если объекты ссылаются на одну и ту же память
        if (obj == null || getClass() != obj.getClass()) return false; // Если объекты разных классов
        ElectricPokemon that = (ElectricPokemon) obj;
        return super.equals(obj) && type.equals(that.type); // Сравнение полей name и level
    }

    // Переопределение метода hashCode для вычисления хэш-кода покемона
    @Override
    public int hashCode() {
        int result = type.hashCode(); // Хэш-код для поля type
        return Objects.hash(super.hashCode(), result);
    }
}