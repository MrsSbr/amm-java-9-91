package pokemon;

// Наследник класса AbstractPokemon, представляющий электрического покемона
public class ElectricPokemon extends AbstractPokemon {
    private String type;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ElectricPokemon that = (ElectricPokemon) o;

        return type.equals(that.type);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + type.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ElectricPokemon{" +
                "type='" + type + '\'' +
                '}';
    }
}