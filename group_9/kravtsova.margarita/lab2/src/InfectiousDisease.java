import java.util.ArrayList;
import java.util.Objects;

public class InfectiousDisease extends Disease {
    private String nameInfection;
    private int mortality;                                                      //смертность в процентах
    public InfectiousDisease(String name, ArrayList <String> symptoms,
                             int percentMorbidity, String nameInfection, int mortality) {
        super(name, symptoms, percentMorbidity);
        this.nameInfection = nameInfection;
        this.mortality = mortality;
    }
    public String getNameInfection() {
        return nameInfection;
    }
    public int getMortality() {
        return mortality;
    }
    public void setNameInfection(String nameInfection) {
        this.nameInfection = nameInfection;
    }
    public void setMortality(int mortality) {
        this.mortality = mortality;
    }
    @Override
    public void onsetDisease() {                                                  //начало заболевания
        System.out.println("Инфекция под названием " +
                nameInfection + " неожиданно проникла в организм человека!\n" +
                "У него появляется болезнь под названием " + getName());
    }
    @Override
    public void methodsTreatment () {                                             //методы лечения
        if (mortality == 100) {
            throw new MortalityException("Лечение бесполезно, смертность от данного заболевания 100%");
        }
        System.out.println("Лечение проводится с помощью антибиотиков, и других необходимых лекарств");
    }
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        InfectiousDisease that = (InfectiousDisease) object;
        if (mortality != that.mortality) return false;
        return nameInfection.equals(that.nameInfection);
    }
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + nameInfection.hashCode();
        result = 31 * result + mortality;
        return result;
    }
    @Override
    public String toString() {
        return "InfectiousDisease{" +
                "nameInfection='" + nameInfection + '\'' +
                ", mortality=" + mortality +
                "} " + super.toString();
    }
}
