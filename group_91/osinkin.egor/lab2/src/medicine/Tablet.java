package medicine;

import java.util.Objects;

public abstract class Tablet implements Usable {
    private Double dosage; // Дозировка в таблетках/кг веса
    private String description;
    private String name;

    public Tablet(Double dosage, String description, String name) {
        this.description = description;
        this.dosage = dosage;
        this.name = name;
    }

    public Double getDosage() {
        return dosage;
    }

    public void setDosage(Double dosage) {
        this.dosage = dosage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCountForApplication(Integer weight) {
        return weight * this.dosage;
    }

    public abstract void buy();

    @Override
    public String toString() {
        return "Tablet{" +
                "dosage=" + dosage +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tablet tablet = (Tablet) o;
        return Objects.equals(dosage, tablet.dosage) && Objects.equals(name, tablet.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dosage, name);
    }
}
