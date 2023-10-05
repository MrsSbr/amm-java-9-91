package disease;

import java.util.List;

public class MentalDisease extends Disease{
    private boolean possibilityTreatment;                                          //возможность лечения
    private boolean strangeBehavior;                                               //странное поведение
    public MentalDisease(String name, List<String> symptoms,
                         int percentMorbidity, boolean possibilityTreatment,
                         boolean strangeBehavior) {
        super(name, symptoms, percentMorbidity);
        this.possibilityTreatment = possibilityTreatment;
        this.strangeBehavior = strangeBehavior;
    }
    public boolean isPossibilityTreatment() {
        return possibilityTreatment;
    }
    public boolean isStrangeBehavior() {
        return strangeBehavior;
    }
    public void setPossibilityTreatment(boolean possibilityTreatment) {
        this.possibilityTreatment = possibilityTreatment;
    }
    public void setStrangeBehavior(boolean strangeBehavior) {
        this.strangeBehavior = strangeBehavior;
    }
    @Override
    public void onsetDisease() {                                                    //начало заболевания
        System.out.println("У человека наблюдаются отклонения в поведении.\n" +
                "Видимо, ему нужно обратиться к психологу, " +
                "а при необходимости к психиатру.");
    }
    @Override
    public void methodsTreatment() {                                                //методы лечения
        System.out.println("У пациента выявлено заболевание под названием " + getName());
        if (!possibilityTreatment) {
            throw new MortalityException("Данную болезнь нельзя излечить!");
        } else {
            System.out.println("Пациент будет принимать необходимые лекарства " +
                    "и находиться под присмотром врачей.");
        }
    }
    public void specialCases() {                                                      //наличие особых случаев
        if (strangeBehavior) {
            System.out.println("Этот пациент ведет себя неодекватно, нужно быть с ним осторожнее!");
        } else {
            System.out.println("Поведение данного пациента не опасно для общества.");
        }
    }
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        MentalDisease that = (MentalDisease) object;
        if (possibilityTreatment != that.possibilityTreatment) return false;
        return strangeBehavior == that.strangeBehavior;
    }
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (possibilityTreatment ? 1 : 0);
        result = 31 * result + (strangeBehavior ? 1 : 0);
        return result;
    }
    @Override
    public String toString() {
        return "disease.MentalDisease{" +
                "possibilityTreatment=" + possibilityTreatment +
                ", strangeBehavior=" + strangeBehavior +
                "} " + super.toString();
    }
}
