// Наследник класса AbstractPokemon, представляющий электрического покемона
class ElectricPokemon extends AbstractPokemon {
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
}