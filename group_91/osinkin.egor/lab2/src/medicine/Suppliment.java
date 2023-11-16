package medicine;

import java.util.Objects;

public class Suppliment extends Tablet {
    private String structure;

    public Suppliment(Double dosage, String description, String name, String structure) {
        super(dosage, description, name);
        this.structure = structure;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    @Override
    public void buy() {
        System.out.println("Покупаем БАД " + getName() + "с составом " + structure);
    }

    @Override
    public void use(int weight) {
        System.out.println("Используем БАД: " + this +
                ' ' + "в количестве " +
                getCountForApplication(weight) + "шт.");
    }

    public void feast() {
        System.out.println("Полакомились вкусняшкой " + getName() + "!");
    }

    @Override
    public String toString() {
        return "Suppliment{" +
                "structure='" + structure + '\'' +
                ", " + super.toString() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Suppliment that = (Suppliment) o;
        return Objects.equals(structure, that.structure);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), structure);
    }
}
