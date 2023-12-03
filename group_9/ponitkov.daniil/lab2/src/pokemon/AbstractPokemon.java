package pokemon;

// Абстрактный класс, реализующий общие методы интерфейса Pokemon
 public abstract class AbstractPokemon implements Pokemon {
    private String name;
    private int level;

    // Конструктор с параметрами, инициализирующий поля name и level
    public AbstractPokemon(String name, int level) {
        this.name = name;
        this.level = level;
    }

    // Абстрактный метод speak, который должен быть реализован в подклассах
    public abstract void speak();

    // Публичный метод класса-предка, который можно использовать в подклассах
    public void commonMethod() {
        System.out.println("This is a common method.");
    }
    // Переопределение метода equals для сравнения двух покемонов
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Если объекты ссылаются на одну и ту же память
        if (obj == null || getClass() != obj.getClass()) return false; // Если объекты разных классов
        AbstractPokemon that = (AbstractPokemon) obj; // приведение обьекта к абстракт покемон
        return level == that.level && name.equals(that.name); // Сравнение полей name и level
    }
    // Переопределение метода hashCode для вычисления хэш-кода покемона
    @Override
    public int hashCode() {
        int result = name.hashCode(); // Хэш-код для поля name
        result = 31 * result + level; // Хэш-код для поля level
        return result;
    }
    // Переопределение метода toString для представления покемона в виде строки
    @Override
    public String toString() {
        return "Name: " + name + ", Level: " + level;
    }
}