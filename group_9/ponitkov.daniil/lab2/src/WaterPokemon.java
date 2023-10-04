// Наследник класса AbstractPokemon, представляющий водного покемона
class WaterPokemon extends AbstractPokemon {
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
}