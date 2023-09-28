import java.util.ArrayList;
public class InfectiousDisease extends Disease {
    public String nameInfection;
    public int mortality;//смертность в процентах
    public String getNameInfection() {
        return nameInfection;
    }
    public int getMortality() {
        return mortality;
    }
    @Override
    public String toString(){
        return super.toString() + String.format("Наименование инфекции: %s\nПроцент смертности: %d\n",
                nameInfection, mortality);
    }
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof InfectiousDisease infDis) {
            return (super.equals(infDis)) && (this.nameInfection.equals(infDis.nameInfection))
                    && (this.mortality == infDis.mortality);
        }
        return false;
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }
    public InfectiousDisease(String name, ArrayList <String> symptoms,
                             int percentMorbidity, String nameInfection, int mortality){
        super(name, symptoms, percentMorbidity);
        this.nameInfection = nameInfection;
        this.mortality = mortality;
    }
    @Override
    public void onsetDisease(){ //начало заболевания
        System.out.println("Инфекция под названием " + nameInfection + " неожиданно проникла в организм человека!\n" +
                "У него появляется болезнь под названием " + name);
    }
    @Override
    public void methodsTreatment (){ //методы лечения
        if (mortality == 100) {
            throw new MortalityException("Лечение бесполезно, смертность от данного заболевания 100%");
        }
        System.out.println("Лечение проводится с помощью антибиотиков, и других необходимых лекарств");
    }
}
