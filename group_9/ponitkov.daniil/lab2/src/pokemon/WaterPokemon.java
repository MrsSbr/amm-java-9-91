package pokemon;

// Наследник класса AbstractPokemon, представляющий водного покемона
public class WaterPokemon extends AbstractPokemon {
    private String habitat;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        WaterPokemon that = (WaterPokemon) o;

        return habitat.equals(that.habitat);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + habitat.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "WaterPokemon{" +
                "habitat='" + habitat + '\'' +
                '}';
    }
}