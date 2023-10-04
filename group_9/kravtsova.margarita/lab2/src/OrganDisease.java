import java.util.ArrayList;
import java.util.Objects;

public class OrganDisease extends Disease{
    private String organ;
    private boolean chronic;
    public OrganDisease(String name, ArrayList<String> symptoms,
                        int percentMorbidity, String organ, boolean chronic) {
        super(name, symptoms, percentMorbidity);
        this.organ = organ;
        this.chronic = chronic;
    }
    public String getOrgan() {
        return organ;
    }
    public boolean isChronic() {
        return chronic;
    }
    public void setOrgan(String organ) {
        this.organ = organ;
    }
    public void setChronic(boolean chronic) {
        this.chronic = chronic;
    }
    @Override
    public void onsetDisease() {                                                       //начало заболевания
        System.out.println("У человека заболел огран - это " + organ +
                ". Необходимо обратиться к врачу!");
    }
    @Override
    public void methodsTreatment() {                                                    //методы лечения
        System.out.println("У пациента выявлено заболевание под названием " + getName());
        if (chronic) {
            throw new MortalityException("Данную болезнь нельзя излечить, она хроническая!");
        } else {
            System.out.println("Пациент будет принимать необходимые лекарства " +
                    "и ходить на медикоментозные процедуры.");
        }
    }
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        OrganDisease that = (OrganDisease) object;
        if (chronic != that.chronic) return false;
        return organ.equals(that.organ);
    }
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + organ.hashCode();
        result = 31 * result + (chronic ? 1 : 0);
        return result;
    }
    @Override
    public String toString() {
        return "OrganDisease{" +
                "organ='" + organ + '\'' +
                ", chronic=" + chronic +
                "} " + super.toString();
    }
}
