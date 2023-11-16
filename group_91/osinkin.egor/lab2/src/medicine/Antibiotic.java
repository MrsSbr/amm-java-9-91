package medicine;

import java.util.Objects;

public class Antibiotic extends Tablet {
    private String typeOfIll;

    public Antibiotic(Double dosage, String description, String name, String typeOfIll) {
        super(dosage, description, name);
        this.typeOfIll = typeOfIll;
    }

    public String getTypeOfIll() {
        return typeOfIll;
    }

    public void setTypeOfIll(String typeOfIll) {
        this.typeOfIll = typeOfIll;
    }

    @Override
    public void buy() {
        System.out.println("Покупаем антибиотик " + getName() + "против болезни " + typeOfIll);
    }

    @Override
    public void use(int weight) {
        System.out.println("Используем атнибиотик: " + this +
                ' ' + "в количестве " +
                getCountForApplication(weight) + "шт.");
    }

    @Override
    public String toString() {
        return "Antibiotic{" +
                "typeOfIll='" + typeOfIll + '\'' +
                ", " + super.toString() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Antibiotic that = (Antibiotic) o;
        return Objects.equals(typeOfIll, that.typeOfIll);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), typeOfIll);
    }
}
